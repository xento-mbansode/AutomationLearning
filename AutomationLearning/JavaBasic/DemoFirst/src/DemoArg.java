public class DemoArg {

    void DemoArg(){
        System.out.println("Test");

    }
    DemoArg(){
        System.out.println("Test 2");
    }

    public static void main(String [] args) throws Exception {
//        int a,b;
//        a=Integer.parseInt(args[0]);
//        b=Integer.parseInt(args[1]);
//
//        System.out.println(a+b);
        DemoArg da=new DemoArg();
    }
}