package MultiThreading;

class multithread implements Runnable {
    Thread thread;
    int x;

    multithread(int a, int p) {
        thread = new Thread();
        x = a;
        thread.setPriority(p);
        thread.start();
        run();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(+i + "X" + x + " = " + i * x + " " + thread.getName());
        }
    }
}

public class tableOfNumbersNew {
    public static void main(String[] args) {
        multithread[] myNumbers = new multithread[10];
        System.out.println(myNumbers.length);

        for (int i = 1; i <= myNumbers.length; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Table for: " + i + " ");
                try {
                    myNumbers[i] = new multithread(i, i);
                } catch (IndexOutOfBoundsException e) {
                    //e.printStackTrace();
                }
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }
}
