package MultiThreading;

public class numberToString {
    public static void main(String[] args) {
        int a,b,c,d,e;
        System.out.println("The three digit number is: ");
        a=Integer.parseInt(args[0]);
        System.out.println(a);
        b=a/100;
        c=a%100;
        d=c/10;
        e=c%10;

//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//        System.out.println(e);

        switch (b)
        {
            case 1:
                System.out.print("One Hundred");
                break;
            case 2:
                System.out.print("Two Hundred");
                break;
            case 3:
                System.out.print("Three Hundred");
                break;
            case 4:
                System.out.print("Four Hundred");
                break;
            case 5:
                System.out.print("Five Hundred");
                break;
            case 6:
                System.out.print("Six Hundred");
                break;
            case 7:
                System.out.print("Seven Hundred");
                break;
            case 8:
                System.out.print("One Hundred");
                break;
            case 9:
                System.out.print("Nine Hundred");
                break;
        }
        switch (d)
        {
            case 1:
                System.out.print(" Ten");
                break;
            case 2:
                System.out.print(" Tweny");
                break;
            case 3:
                System.out.print(" Thirty");
                break;
            case 4:
                System.out.print(" Fourty");
                break;
            case 5:
                System.out.print(" Fifty");
                break;
            case 6:
                System.out.print(" Sixty");
                break;
            case 7:
                System.out.print(" Seventy");
                break;
            case 8:
                System.out.print(" Eighty");
                break;
            case 9:
                System.out.print(" Ninety");
                break;
        }
        switch (e)
        {
            case 1:
                System.out.print(" One");
                break;
            case 2:
                System.out.print(" Two");
                break;
            case 3:
                System.out.print(" Three");
                break;
            case 4:
                System.out.print(" Four");
                break;
            case 5:
                System.out.print(" Five");
                break;
            case 6:
                System.out.print("Six");
                break;
            case 7:
                System.out.print(" Seven");
                break;
            case 8:
                System.out.print(" Eight");
                break;
            case 9:
                System.out.print(" Nine");
                break;
        }

    }
}
