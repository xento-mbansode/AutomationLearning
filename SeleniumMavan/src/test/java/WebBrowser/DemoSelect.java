package WebBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemoSelect {
    public static void main(String[] args) throws Exception {
        String url="https://demoqa.com/select-menu";
        System.setProperty("webdriver.chrome.driver","/C:/Dependancy/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Create the object of the Select class
        Select se = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
        // Select the option using the visible text
        se.selectByVisibleText("Black");
        System.out.println(se.getFirstSelectedOption());

        // Using action and perform method selection into new dropdwon selection list
        driver.findElement(By.cssSelector("#selectOne")).click();
        System.out.println("1");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#selectOne > div")).sendKeys("Mr.");
        Thread.sleep(1000);
        System.out.println("2");

        System.out.println("3");
    }
}
