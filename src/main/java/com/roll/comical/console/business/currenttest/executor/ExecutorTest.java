package com.roll.comical.console.business.currenttest.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

    public static void main(String[] args){
        ThreadTest threadTest = new ThreadTest();
        Executor executor = new ThreadPoolExecutor(1,1,1, TimeUnit.MINUTES,new LinkedBlockingQueue<>(1));

        executor.execute(threadTest);
    }


}

class ThreadTest extends Thread{
    @Override
    public void run(){
        System.out.println(System.currentTimeMillis());
    }
}