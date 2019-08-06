package myshop.comromygreat.uiautomation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {
   static ExecutorService instance;

    public static ExecutorService getExeCutor(){
        if (instance==null)
        {instance= Executors.newFixedThreadPool(5);
        }
        return instance;
    }
    public static void startThread(Runnable runnable){
        getExeCutor().execute(runnable);
    }
}
