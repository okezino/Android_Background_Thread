
# Android_Background_Thread

This is a very short project that demonstrate the Android Background Thread system, how the Java Thread can be manage using so Android component like 
Handlers, looper and messagequeue, we will shallowly talk about this concepts and give pictorial diagram to will help visualize this concept.

## There are 2 Java Component we need to learn
### 1. Thread class
In other to create a background thread, we need to call the Thread class and override the run function, once this class is called, we need to use the start function to start running the thread.
     
    declare the background class
     class  BackgroundThread : Thread(){
    override fun run() {
        super.run()
        //work that is to be done by the thread
         TODO("Not yet implemented")
    }   }

     //create an intsance of the background thread
     var backgroundThread = BackgroundThread()

     //start the background thread
     backgroundThread.start()

    start an anonymous thread
    // this create a thread, takes a Runnable as paramter and starts the thread with the start function
     Thread(object : Runnable{
            override fun run() {
                TODO("Not yet implemented")
            }

        }).start()

   
### Runnable Interface 
A Runnable is  Task that can be executed by a thread, its an interface with the run function,
all the executable code are place in the run function. 
    
    ```
    This is a simple declaration of a runnable that loops 5 times and print its value in the logcat
      val runnable : Runnable = object : Runnable{
            override fun run() {
                for(i in 0 until 5){
                Log.d("ThreadName", "$i")
                }
            }

        }
    ```
    
  ##Note : A Thread execute tasks in the form of Runnables, In Android the main thread Runs in by default on an infinite loop until the app is killed, it is done
     by the help of the looper, looper is an Android component, we will talk about it later however other background thread runs and terminate once the task 
     assign to it has be executed and cant be called again.
     
     
  ## There a 3 Android components that helps to execute a thread and enable thread interaction [MessageQueue, Handler and looper]  
  
  ### @MessageQueue :: this is a stack of task(Runnable) that is been executed by the thread, all task  has an execution time stamp
  
  ### @Handler :: The handler add task(Runnable) to the MessageQueue and also collect task with stamp stamp now or past time from the looper to execute, The handler   can also Task a Message from another thread and add to the MessageQueue of that thread
  
  ### @looper :: the looper is like a loop, that runs through the MessageQueue, Picks up Task(Runnable) and send to the handler to execute
     
     <img width="537" alt="Screenshot 2021-12-12 at 00 00 06" src="https://user-images.githubusercontent.com/46386915/145721335-b25667a3-19aa-421e-969c-651cfd62da2f.png">
    
    

