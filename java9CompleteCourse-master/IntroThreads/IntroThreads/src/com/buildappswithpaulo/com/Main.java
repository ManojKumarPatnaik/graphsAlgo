package com.buildappswithpaulo.com;



public class Main {
    static int counter = 1;

    public static void main(String[] args) {




//        System.out.println("Main thread starting.");
//
//        //construct myThread object
//        MyThread mt = new MyThread("Child #1");
//        MyThread mt2 = new MyThread("Child #2");
//        MyThread mt3 = new MyThread("Child #3");
//
//
//        try {
//
//            mt.thread.setPriority(Thread.NORM_PRIORITY);
//            System.out.println("Child #1 Priority is  " + mt.thread.getPriority());
//            mt2.thread.setPriority(Thread.MIN_PRIORITY);
//            System.out.println("Child #2 Priority is  " + mt2.thread.getPriority());
//            mt3.thread.setPriority(Thread.MAX_PRIORITY);
//            System.out.println("Child #3 Priority is  " + mt3.thread.getPriority());
////            mt.thread.join(); //wait until specified thread ends
////            System.out.println("Child #1 joined" + "Priority:  " + mt.thread.getPriority());
////            mt2.thread.join();
////            System.out.println("Child #2 joined");
////            mt3.thread.join();
////            System.out.println("Child #3 joined");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//

//        do {
//            System.out.println(".");
//
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                System.out.print("Main thread interrupted");
//                e.printStackTrace();
//            }
//
//
//
//        }while (mt.thread.isAlive() || mt2.thread.isAlive() || mt3.thread.isAlive());
//
//
//        System.out.print("Main thread ending");


//        for (int i = 0; i < 50; i++) {
//            System.out.print(".");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                System.out.print("Main thread interrupted");
//                e.printStackTrace();
//            }
//        }
//        System.out.print("Main thread ending");

        //Construct an actual thread from our previous object
        //Thread newThread = new Thread(mt);
       // newThread.start();

    }

    public static int getId(){
        return counter++;
    }
}


class MyThread implements Runnable{
    Thread thread;

    String myThread;
    @Override
    public void run() {
        System.out.println(myThread + " Starting");
        for (int count = 0; count < 10; count++) {
            try {
                Thread.sleep(400);
                System.out.println("In " + myThread + " count is " +
                   count);
            } catch (InterruptedException e) {
                System.out.println(myThread + " interrupted");
                e.printStackTrace();
            }
            System.out.println(myThread + " terminated");

        }

    }

    public MyThread(String myThread) {

        this.myThread = myThread;

        thread = new Thread(this, myThread);
        thread.start();





    }
}
