package MultiThreading;

class testThreadDemo implements Runnable{
    Thread thread;
    testThreadDemo(String s){
        thread=new Thread(s);
        System.out.println("Child Thread Created");
            thread.start();
        System.out.println("Started");
        run();
     }

    public void run(){
        int i;
        for (i=0;i<5;i++){
            try{
                System.out.println("Child Thread: " +thread.getName());
                Thread.sleep(500);
            }catch(InterruptedException e){
               e.printStackTrace();
            }
        }
    }
}
public class demoThread2 {
    public static void main(String[] args) {
        int i;
        testThreadDemo t1=new testThreadDemo("One");
        testThreadDemo t2=new testThreadDemo("Two");
        testThreadDemo t3=new testThreadDemo("Three");

        for (i=0;i<5;i++){
            try{
                System.out.println("Main Thread: "+i);
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
