package com.bookstore.qa.base;
import com.bookstore.qa.util.TestUtil;
import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public TestBase(){

        try{
        prop=new Properties();
           FileInputStream ip=new FileInputStream("src/main/java/com/bookstore/qa/config/config.properties");
           // FileReader reader=new FileReader("config.properties");
            prop = new Properties();
            prop.load(ip);
    }catch (FileSystemNotFoundException | IOException e){
            e.printStackTrace();
        }
    }
    public static void initialization(){
        String browserName=prop.getProperty("browser");
        System.out.println(prop.getProperty("browser"));
        if (browserName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver","/C:/Dependancy/chromedriver_win32/chromedriver.exe");
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }


}
