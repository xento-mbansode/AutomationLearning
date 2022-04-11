package UsingJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolsQAPracticeForm {
    WebDriver driver;
    //close the add
    public void closeAdds(){
        driver.findElement(By.cssSelector("#close-fixedban")).click();
        System.out.println("add closed");
    }
    @Before
    public void setup(){
        String url="https://demoqa.com";
        System.setProperty("webdriver.chrome.driver","/C:/Dependancy/chromedriver_win32/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("-----------Test Started------------");
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(2) > div > div.avatar.mx-auto.white")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='item-0']/span[contains(text(),'Practice Form')]")).isDisplayed());
    }
    @Test
    public void submitPracticeForm() throws Exception{
        driver.findElement(By.xpath("//*[@id='item-0']/span[contains(text(),'Practice Form')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#firstName")).sendKeys("TestFirst");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("TestLast");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("test@test.lcl");
        driver.findElement(By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label")).click();
        System.out.println("Clicked on Male combo button");
        driver.findElement(By.cssSelector("#userNumber")).sendKeys("1123456789");
        System.out.println("Entered the mobile number");
        //String subject="Test subject for automation program";
//        driver.findElement(By.xpath("//*[@id='subjectsContainer']/div")).sendKeys(subject);
        driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[2]/label[contains(text(),'Reading')]")).click();
        System.out.println("Hobby as reading is selected");
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Manjri, Shewalewadi Road Pune -411027");

        WebElement dropdown= driver.findElement(By.cssSelector("div#state div[class$='placeholder']"));
        dropdown.click();
        Thread.sleep(2000);
        WebElement options=driver.findElement(By.xpath("//*[contains(text(), 'Uttar Pradesh')]"));
        options.click();
        Thread.sleep(2000);
        System.out.println("State selected");

        WebElement citydropdown=driver.findElement(By.cssSelector("div#city div[class$='placeholder']"));
        citydropdown.click();
        Thread.sleep(2000);
        WebElement cityoptions=driver.findElement(By.xpath("//*[contains(text(),'Agra')]"));
        cityoptions.click();
        Thread.sleep(2000);
        System.out.println("City selected");
        driver.findElement(By.cssSelector("#submit")).click();
        String successMessageText="Thanks for submitting the form";
        if(driver.getPageSource().contains(successMessageText)){
            System.out.println("sucess");
        }
        driver.findElement(By.id("closeLargeModal")).click();
    }

    @After
    public void endTest(){
        driver.quit();
        System.out.println("----------------------------");
        System.out.println("Test has ended");
    }
}

