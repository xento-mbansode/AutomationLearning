package ExceptionHandelling;

public class DemoExcepMultiCatch {
    public static void main(String[] args) {
        int a,b,c;
        a=10;
        b=0;
        int arr[]=new int[2];

        try{
            System.out.println("Before");
            arr[3]=10;
            c=a/b;
        }catch(ArithmeticException e){
            e.printStackTrace();
            System.out.println("Devide by Zero exception");
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("Index out of bound exception");
        }
    }
}
