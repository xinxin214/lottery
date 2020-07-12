package echang.cxx.lottery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //抽奖名单
    var names= listOf<String>("张三","李四","王五","赵六")
    //定时器，每隔一段时间切换一次
    lateinit  var timer: Timer
    //记录当前索引
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun init(){
        //设置默认显示的一个人
        mtextview.text = names[index]
        //添加按钮点击事件
        startbutton.setOnClickListener()
        {
            //判断标题是start/stop
            if(

                startbutton.text.toString() == "SATRT"
                    ) {
                startbutton.text = "STOP"
                //创建定时器
                timer = Timer()
                //分配一个定时任务
                timer.run {
                    schedule(object : TimerTask(){
                                override fun run() {
                                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                    //判断是否越界
                                    index= if(index+1>names.size-1) 0 else index++
                                    Log.v("cxx","$index")
                                    //取出对应的名字
                                    mtextview.text = names[index]
                                }
                            },0,100)
                }
            }else {
                startbutton.text = "START"
                timer.cancel()
            }
        }
    }
}
