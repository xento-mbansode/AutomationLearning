package UsingJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ToolsQAInteractionAutomation {
    WebDriver driver;
    //close the add
    public void closeAdds(){
        driver.findElement(By.cssSelector("#close-fixedban")).click();
        System.out.println("add closed");
    }
    @Before
    public void setup() throws Exception{
        String url="https://demoqa.com";
        System.setProperty("webdriver.chrome.driver","/C:/Dependancy/chromedriver_win32/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("-----------Test Started------------");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(5) > div > div.card-body > h5")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div[contains(text(),'Interactions')]")).isDisplayed());
    }
    @Test
    public void testSortable() throws Exception{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(1000);
        WebElement from;
        driver.findElement(By.xpath("//*[@id=\"item-0\"]/span[contains(text(),'Sortable')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()) {
            this.closeAdds();
        }
        System.out.println(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div")).getText());
        Actions move=new Actions(driver);
        List<WebElement> slist=driver.findElements(By.xpath("//*[@id='demo-tabpane-list']/div/div"));
        for (WebElement s: slist ) {
            System.out.println("List: "+s.getText());
            if(s.getText().equals("Four")){
               from=s;
                int xOffset = from.getLocation().getX();
                int yOffset =  from.getLocation().getY();
                System.out.println("X location: "+xOffset +" Y location "+yOffset);
                Thread.sleep(2000);
                move.dragAndDropBy(from,xOffset-100,yOffset+250).perform();
                Thread.sleep(1000);
                System.out.println("Done");
            }

        }


    }
    @After
    public void endTest(){
       // driver.quit();
        System.out.println("----------------------------");
        System.out.println("Test has ended");
    }
}
