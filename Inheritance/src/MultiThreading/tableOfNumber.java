package MultiThreading;

class number implements Runnable {
    Thread thread;
    int x;
    number(int a, int p){
        thread=new Thread();
        x=a;
        thread.setPriority(p);
        thread.start();
        run();
    }
         @Override
    public void run() {
    for(int i=1;i<=10;i++){
        System.out.println(+i +"X" +x +" = "+i*x +" "+thread.getName());
    }
    }
}
public class tableOfNumber {
    public static void main(String[] args) {
        System.out.println("Table for 3");
     number n1=new number(3,1);
        System.out.println("Table for 5");
     number n2=new number(5, 5);
        System.out.println("Table for 7");
     number n3=new number(7, 10);
    }
}

