public class MathAdd {
    public static void main(String [] args) throws Exception {
        int i,j;
        int a[][]={{10,20},{30,40}};
        int b[][]={{100,200},{300,400}};

        int c[][]=new int[2][2];
        for ( i=0;i<2;i++){
            for(j=0;j<2;j++){

                c[i][j]=a[i][j]+b[i][j];

            }
        }

        for(i=0;i<2;i++){
            for(j=0;j<2;j++){

                System.out.println(c[i][j]);
            }
        }
    }
}