package MultiThreading;

class test implements Runnable{
    Thread thread;
    test(String s){
        thread =new Thread(s);
        System.out.println("Child Thread is created");
        thread.start();
        run();
    }

    @Override
    public void run() {
        int i;
        for (i=0;i<5;i++){
            try{
                System.out.println("Child thread: "+thread.getName());
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class demoThread3 {
    public static void main(String[] args) {

        test t1=new test("one");
        test t2=new test("two");
        test t3=new test("three");
        System.out.println("Threa one is Alive: "+t1.thread.isAlive());
        System.out.println("Threa one is Alive: "+t2.thread.isAlive());
        System.out.println("Threa one is Alive: "+t3.thread.isAlive());

        try{
            System.out.println(" Main Thread ");
            t1.thread.join(1000);
            System.out.println(t1.thread.getName());
            t2.thread.join(1000);
            System.out.println(t2.thread.getName());
            t3.thread.join(1000);
            System.out.println(t3.thread.getName());
        }catch(InterruptedException e){
              e.printStackTrace();
        }
    }
}
