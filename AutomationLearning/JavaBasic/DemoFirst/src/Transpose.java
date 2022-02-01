public class Transpose {
    public static void main(String [] args){
     int i,j;
        int a[][]={{10,20},{30,40}};

        System.out.println("before transpose");
        for(i=0;i<2;i++){
            for(j=0;j<2;j++){
                System.out.print(" i = "+i );
                System.out.println(" j = "+j );
                System.out.println(a[i][j]);
            }
        }
        System.out.println("-----transpose-----");
        for(i=0;i<2;i++){
            for(j=0;j<2;j++){
                System.out.print(" i = "+i );
                System.out.println(" j = "+j );
                System.out.println(a[j][i]);
            }
        }

    }
}