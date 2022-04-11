package ArrayListConcept;

public class TimeManagement {
    public static String toTime(int seconds){
        int hour=seconds/3600;
        int min=seconds/60;
        int reminder=seconds%3600;
        System.out.println(seconds);
        System.out.println(min);
        System.out.println(hour);
        System.out.println(reminder);

        if(min<60){
            System.out.println(hour+" hour(s) and "+min+" minute(s)");
            return hour+" hour(s) and "+min+" minute(s)";
        }
        if(min==60 && hour==1){
            System.out.println(hour+" hour(s) and 0 minute(s)");
        }
        if(min>60){
            System.out.println(hour+" hour(s) and "+ reminder/60 +" minute(s)");
        }
        return "";

    }
    public static void main(String[] args) {
        toTime(3600);
        System.out.println("***********");
        toTime(3601);
        System.out.println("***********");
        toTime(3500);
        System.out.println("***********");
        toTime(323500);
        System.out.println("***********");
        toTime(0);
        System.out.println("***********");
    }
}
