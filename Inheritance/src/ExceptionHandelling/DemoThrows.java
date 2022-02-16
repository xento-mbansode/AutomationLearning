package ExceptionHandelling;

public class DemoThrows {
    public static void main(String[] args) {
       div(); // if called from here then exception handled from throws
        try {
         //   div(); //if called from here then exception handled from try catch
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("Caught in main");
        }
    }

    static void div() throws ArithmeticException, IndexOutOfBoundsException {
        System.out.println("In div method");
        int a, b, c;
        a = 10;
        b = 0;
        c = a / b;
    }
}

