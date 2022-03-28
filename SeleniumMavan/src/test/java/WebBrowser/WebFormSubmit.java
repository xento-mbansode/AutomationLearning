package WebBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.sound.midi.Soundbank;

import static java.lang.Thread.sleep;

public class WebFormSubmit {
    public static void main(String[] args) throws Exception{
        String url="https://demoqa.com/";
        System.setProperty("webdriver.chrome.driver","/C:/Dependancy/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
       try {
           driver.get(url);
           driver.manage().window().maximize();
           System.out.println("Driver loaded waiting for page to load");
           Thread.sleep(1000);
           Boolean diplayed= driver.findElement(By.cssSelector("div:nth-child(2) > div > div.avatar.mx-auto.white")).isDisplayed();
           System.out.println("Element" + "" +diplayed );
           driver.findElement(By.cssSelector("div:nth-child(2) > div > div.avatar.mx-auto.white")).click();
           driver.findElement(By.xpath("//*[@id=\"item-0\"]/span[contains(text(),'Practice')]")).click();
           driver.findElement(By.cssSelector("#firstName")).sendKeys("TestFirst");
           driver.findElement(By.cssSelector("#lastName")).sendKeys("TestLast");
           driver.findElement(By.cssSelector("#userEmail")).sendKeys("test@test.lcl");
           driver.findElement(By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label")).click();
           System.out.println("Clicked on Male combo button");
           driver.findElement(By.cssSelector("#userNumber")).sendKeys("0123456789");
           System.out.println("Entered the mobile number");
//            driver.findElement(By.cssSelector("#dateOfBirthInput")).clear();
//                      driver.findElement(By.cssSelector("#dateOfBirthInput")).sendKeys("14 Jan 1985");
           String subject="Test subject for automation program";
           //driver.findElement(By.cssSelector("div.subjects-auto-complete__placeholder.css-1wa3eu0-placeholder")).sendKeys(subject);
           driver.findElement(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label")).click();
           System.out.println("Hobby as reading is selected");
           driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Manjri, Shewalewadi Road Pune -411027");

           System.out.println("Closing the adds");
           driver.findElement(By.cssSelector("#close-fixedban")).click();

           //creating select method for single select dropdown
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

           driver.findElement(By.cssSelector("#submit")).submit();
           String successMessageText="Thanks for submitting the form";
           if(driver.getPageSource().contains(successMessageText)){
               System.out.println("sucess");
           }
//           if(driver.findElement(By.cssSelector("#example-modal-sizes-title-lg")).getText().equals(successMessageText)){
//               System.out.println();
//           }

       }catch(Exception e){
           e.printStackTrace();
         }
        finally {
          // driver.quit();
           System.out.println("Program ended");
       }

    }
}
