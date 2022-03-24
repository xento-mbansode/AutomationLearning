package WebBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSelenium {
    public static void main(String[] args) {
        String url="https://demoqa.com/";
        System.setProperty("webdriver.chrome.driver","/C:/Dependancy/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        System.out.print("Page Title: ");
        System.out.println(driver.getTitle());
        System.out.print("Page Scource: ");
        System.out.println(driver.getPageSource());
        System.out.print("Available cookies on page: ");
        System.out.println(driver.manage().getCookies());
        driver.quit();
        System.out.println("******** Closed the driver instance *********");
    }
}
