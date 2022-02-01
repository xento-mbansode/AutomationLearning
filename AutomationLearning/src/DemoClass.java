public class DemoClass {
    public void show(){
        System.out.println("in method show");
      }

      public static void main(String[] args){
          System.out.println("In main method");
         //creating object of class
          DemoClass object=new DemoClass();
         //calling method
          object.show();
      }
}