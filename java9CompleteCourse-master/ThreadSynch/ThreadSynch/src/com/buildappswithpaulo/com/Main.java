package com.buildappswithpaulo.com;


public class Main {


    public static void main(String args[]) {
        First first = new First();
        Second one = new Second(first, "welcome");
        Second two= new Second (first,"new");
        Second three = new Second(first, "programmer");

    }

}

class First {
       void display(String msg) {
        System.out.print (" [ "+msg);
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println (" ] ");
    }
}

class Second extends Thread {
    String msg;
    First fobj;
    Second (First fp,String str) {
        fobj = fp;
        msg = str;
        start();
    }
    public void run() {

        //synchronized (fobj){
            fobj.display(msg);
        //}

    }
}