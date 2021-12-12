package com.example.android_background_proccess

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_background_proccess.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        runCall()
        binding?.button?.setOnClickListener {
            runAction()
        }
    }

    /**
     * There are 2 Java Class we need to learn
     * 1..Thread Class
     * 2..Runnable Interface
     *
     * @Thread
     *    A Background thread is called when we need to run a task on the Background not on the UI thread
     *    Thread can take a Runnable as an argument to run
     *
     *  @Runnable
     *     Runnable are Task that can be executed by a thread, its an interface with the run function,
     *     all the code to be run are place in the run function that is overrode
     *
     *     Note : By default the MAin OR UI THREAD runs on an infinite loop until the app is killed, it is done
     *     by the help of the looper, looper is an Android component, we will talk about it later however Normal
     *     thread runs and end and  cant be called again.
     *
     *     There a 3 Android components that helps to execute a thread and enable thread interaction
     *     [MessageQueue, Handler and looper]
     *
     *     @MessageQueue :: this is a stack of task(Runnable) that is been executed by the thread, all task
     *     has an execution time stamp
     *
     *     @Handler :: The handler add task(Runnable) to the MessageQueue and also collect task with stamp
     *     stamp now or past time from the looper to execute, The handler can also Task a Message from another
     *     thread and add to the MessageQueue of that thread
     *
     *     @looper :: the looper is like a loop, that runs through the MessageQueue, Picks up Task(Runnable)
     *     and send to the handler to execute
     *
     *     :: An Handler can not work without a looper ...for a non main thread, once you create an Handler
     *     you need to create a looper
     *
     *
     */


    val runnableTask = object : Runnable {
        override fun run() {
            Thread.sleep(10000)
            /**
             *
             */

            runOnUiThread {
                binding!!.textView.text = "Button Click"
            }

        }
    }
    var a  =  Thread(runnableTask)


    @SuppressLint("SetTextI18n")
    fun runAction() {
        a.start()
    }

    fun runCall() {
        binding?.call?.setOnClickListener {
            count++
            binding!!.textView.text = "${count}"

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}