package TestingFiles;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class TestPropertiesFile {
    public static void main(String[] args) throws Exception{

        //using read class

       try {
           System.out.println("Using reader class");
           FileReader reader = new FileReader("src/TestingFiles/testing.properties");

           Properties p = new Properties();
           p.load(reader);

           System.out.println(p.getProperty("url"));
           System.out.println(p.getProperty("username"));
           System.out.println(p.getProperty("password"));
           System.out.println(p.getProperty("browser"));

       }catch (IOException | IndexOutOfBoundsException e){
           e.printStackTrace();
       }
        //using Input Stream

        System.out.println("Using input stream class");
        FileInputStream ip=new FileInputStream("src/TestingFiles/testing.properties");

        Properties p = new Properties();
        p.load(ip);

        System.out.println(p.getProperty("url"));
        System.out.println(p.getProperty("username"));
        System.out.println(p.getProperty("password"));
        System.out.println(p.getProperty("browser"));
    }
}
