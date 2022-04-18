package UsingJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.lang.model.element.Element;
import java.util.List;

public class ToolsQaWidgetsAutomation {
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
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(4) > div > div.card-body > h5")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[4]/span/div/div[1]")).isDisplayed());
    }
    @Test
        public void testAccordian(){
       driver.findElement(By.xpath("//*[@id='item-0']/span[contains(text(),'Accordian')]")).click();
       if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()) {
           this.closeAdds();
       }
        System.out.println(driver.findElement(By.className("card-header")).getText());
       if(driver.findElement(By.cssSelector("#accordianContainer > div > div:nth-child(1) > div.collapse.show")).isDisplayed()) {
           //System.out.println("Inside If");
           //driver.findElement(By.className("card-header")).click();
           System.out.println(driver.findElement(By.cssSelector("#section1Content > p")).getText());
       }
        System.out.println("2nd");
        System.out.println(driver.findElement(By.id("section2Heading")).getText());
       if(!driver.findElement(By.cssSelector("#accordianContainer > div > div:nth-child(2) > div.collapse")).isDisplayed()){
           driver.findElement(By.id("section2Heading")).click();
           System.out.println(driver.findElement(By.xpath("//*[@id='section2Content']/p[1]")).getText());
       }
        System.out.println(driver.findElement(By.xpath("//*[@id='section2Content']/p[1]")).getText());
    }
    @Test
    public void testAutocomplete() throws Exception{
        driver.findElement(By.xpath("//*[@id='item-1']/span[contains(text(),'Auto Complete')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()) {
            this.closeAdds();
        }
        WebElement autoinput = driver.findElement(By.xpath("//span[contains(text(),'Auto Complete')]"));
        autoinput.click();
        Thread.sleep(2000);
        WebElement inputbox = driver.findElement(By.id("autoCompleteSingleInput"));
        inputbox.sendKeys("red");
        Thread.sleep(2000);
        Actions act = new Actions(driver);
        act.sendKeys(inputbox, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        //multi-select autocomplete box
        WebElement autoMultiSelect=driver.findElement(By.cssSelector("#autoCompleteMultipleContainer > div"));
        autoMultiSelect.click();
        Thread.sleep(2000);
        WebElement inputMultiSelectBox=driver.findElement(By.id("autoCompleteMultipleInput"));
        inputMultiSelectBox.sendKeys("Red");
        Thread.sleep(2000);
        act.sendKeys(inputMultiSelectBox, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        inputMultiSelectBox.sendKeys("Yellow");
        Thread.sleep(2000);
        act.sendKeys(inputMultiSelectBox, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

    }

    @Test
    public void testDatepicker() throws Exception{
        driver.findElement(By.xpath("//*[@id='item-2']/span[contains(text(),'Date Picker')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()) {
            this.closeAdds();
        }
        driver.findElement(By.xpath("//span[contains(text(),'Date Picker')]")).click();
        WebElement date = driver.findElement(By.id("dateAndTimePickerInput"));
        date.click();
        Thread.sleep(3000);

        String monthyearval = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']")).getText();
        System.out.println(monthyearval);
        String month = monthyearval.split(" ")[0].trim();
        String year = monthyearval.split(" ")[1].trim();
        while (!(month.equals("July") && year.equals("2022"))) {
            driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
            Thread.sleep(500);
            monthyearval = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']")).getText();
            System.out.println(monthyearval);
            month = monthyearval.split(" ")[0].trim();
            year = monthyearval.split(" ")[1].trim();
        }
        Thread.sleep(200);
        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[@aria-label='Choose Saturday, July 2nd, 2022']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@class='react-datepicker__time-list']//li[contains(text(),'02:00')]")).click();

    }

    @Test
    public void testSlider() throws Exception{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//*[@id='item-3']/span[contains(text(),'Slider')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()) {
            this.closeAdds();
        }
        Thread.sleep(2000);
      // driver.findElement(By.xpath("//span[contains(text(),'Slider')]")).click();
      // System.out.println(driver.findElement(By.className("card-header")).getText());
        //System.out.println("Test1");
       WebElement slider=driver.findElement(By.xpath("//*[@id='sliderContainer']/div[1]/span/input"));
        Actions act=new Actions(driver);
        Thread.sleep(1000);
       // act.dragAndDropBy(slider,80,0).build().perform();
        act.click(slider).clickAndHold().moveByOffset(250,250).release().perform();
        Thread.sleep(2500);
        act.click(slider).clickAndHold().moveByOffset(-250,250).release().perform();
        Thread.sleep(2500);
        System.out.println("Final slider value is: "+driver.findElement(By.id("sliderValue")).getCssValue("value"));
    }

    @Test
    public void testProgressBar() throws Exception{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//*[@id='item-4']/span[contains(text(),'Progress Bar')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()) {
            this.closeAdds();
        }
        System.out.println(driver.findElement(By.className("main-header")).getText());
        driver.findElement(By.id("startStopButton")).click();
        Thread.sleep(2000);
//        String value=driver.findElement(By.xpath("//*[@id='progressBar']/div")).getAttribute("aria-valuenow");
//        if(value.equals("30")) {
//            driver.findElement(By.id("startStopButton")).click();
//        }
        driver.findElement(By.id("startStopButton")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='progressBar']/div")).getAttribute("aria-valuenow"));
    }

    @Test
    public void testTabs() throws Exception {
        String ids="";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//*[@id='item-5']/span[contains(text(),'Tabs')]")).click();
        if (driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()) {
            this.closeAdds();
        }
        System.out.println(driver.findElement(By.className("main-header")).getText());

        List<WebElement> tabNames=driver.findElements(By.cssSelector("#tabsContainer > nav>a"));
        for (WebElement tab: tabNames){
            System.out.println("Clicked on "+tab.getText());

            ids=tab.getAttribute("id");
         //   System.out.println(driver.findElement(By.xpath("/*[@id="+ids+"]/p/text()")).getText());
          //  System.out.println(driver.findElement(By.xpath("/*[@id=\"ids\"]/p/text()")).getText());

            if(tab.getText().equals("More")){
                System.out.println("More is not clickable");
                break;
            }
            tab.click();
        }
    }
    @Test
    public void voidTestToolTip()throws Exception{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
                driver.findElement(By.xpath("//*[@id='item-6']/span[contains(text(),'Tool Tips')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()) {
            this.closeAdds();
        }
       // System.out.println(driver.findElement(By.className("card-header")).getText());
        Thread.sleep(2000);
        Actions act=new Actions(driver);
        WebElement ele = driver.findElement(By.id("toolTipButton"));
        act.moveToElement(ele).perform();
        System.out.println("action performed");
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("buttonToolTip")).getText());



    }
    @Test
    public void voidTestMenu()throws Exception{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='item-7']/span[contains(text(),'Menu')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()) {
            this.closeAdds();
        }
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div")).getText());
        List<WebElement> menuNames=driver.findElements(By.id("nav"));
        for (WebElement menu: menuNames) {
            System.out.println(menu.getText());
            }
    }

    @After
    public void endTest(){
        driver.quit();
        System.out.println("----------------------------");
        System.out.println("Test has ended");
    }
}
