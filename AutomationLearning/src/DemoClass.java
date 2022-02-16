public class DemoClass {
    public int x;
    private int y;

    void cal(int a, int b){
        x=a+1;
        y=b;
    }

    void print(){
        System.out.println(" " +y);
            }

    public void show(){
        System.out.println("in method show");
      }

      public static void main(String[] args){
          System.out.println("In main method");
         //creating object of class
          DemoClass object=new DemoClass();
         //calling method
          object.show();

          object.cal(2,3);
          System.out.println(object.x);
          object.print();
            }
}