package MultiThreading;

class testThread implements Runnable{
    //Multithreading using Runnable interface
    Thread t;
    testThread(){
       t=new Thread();
        System.out.println("Child thread created");
       t.start();
     }

    @Override
    public void run() {
        int i;
        for (i=0;i<5;i++){
            try{
                System.out.println("Child Thread: " +i);
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class demoThread {
    public static void main(String[] args) {
     testThread objt=new testThread();
     for (int i=0;i<5;i++){
         try{
             System.out.println("Main thread: " +i);
             objt.run();
             Thread.sleep(1000);
         }catch (InterruptedException e){
             e.printStackTrace();
         }
       }
    }
}
