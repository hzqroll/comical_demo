package com.roll.comical.console.business.jvm1;

public class JavaVmStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    private void dontstop(){


        while (true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontstop();
                }
            });
            thread.start();
        }
    }
    public static void main(String[]  args){
        JavaVmStackSOF javaVmStackSOF = new JavaVmStackSOF();
       javaVmStackSOF.stackLeakByThread();
    }
}
