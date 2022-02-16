package ExceptionHandelling;

public class DemoExcept {
    public static void main(String[] args) {
        int a,b,c;
        a=10;
        b=0;
        try{
            System.out.println("Before condition");
            c=a/b; // Here Arithmetic Exception will occur
            System.out.println("Never Executed");
        } catch (ArithmeticException e){ //exception got caught inside catch block
            e.printStackTrace();
            System.out.println("Exception Occurred");
         }
        System.out.println("After execution");
    }
}
