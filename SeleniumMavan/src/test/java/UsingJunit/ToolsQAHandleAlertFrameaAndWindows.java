package UsingJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ToolsQAHandleAlertFrameaAndWindows {

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
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(3) > div > div.avatar.mx-auto.white")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='item-0']/span[contains(text(),'Browser Windows')]")).isDisplayed());
    }
    @Test
    public void testBrowserWindowNewTab(){
        driver.findElement(By.xpath("//*[@id='item-0']/span[contains(text(),'Browser Windows')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        System.out.println(driver.findElement(By.className("main-header")).getText() +" this is the current page");
        driver.findElement(By.cssSelector("#tabButton")).click();
        ArrayList<String> tabs2=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        System.out.println(driver.findElement(By.id("sampleHeading")).getText() +" this is on the newly opened tab");
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        System.out.println(driver.findElement(By.className("main-header")).getText() +" this is the previous tab");
    }
    @Test
    public void testBrowserWindowNewWindow(){
        driver.findElement(By.xpath("//*[@id='item-0']/span[contains(text(),'Browser Windows')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        System.out.println(driver.findElement(By.className("main-header")).getText() +" this is the current page");
        driver.findElement(By.id("windowButton")).click();
        String mainWindowHandle= driver.getWindowHandle();
        Set<String> allWindowHadnles=driver.getWindowHandles();
        for (String childWindow : allWindowHadnles) {
            if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is: " + text.getText());
            }
        }
     }
    @Test
    public void testBrowserWindowNewWindowMessage() {
        driver.findElement(By.xpath("//*[@id='item-0']/span[contains(text(),'Browser Windows')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        System.out.println(driver.findElement(By.className("main-header")).getText() +" this is the current page");

        // Opening all the child window
        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();

        String MainWindow = driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);

        // To handle all new opened window
        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);

        // Here we will check if child window has other child windows and when child window
        //is the main window it will come out of loop.
        for (String ChildWindow : s1) {
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
               // System.out.println(driver.manage().window().getSize());
                driver.close();
                System.out.println("Child window closed");
            }
        }
    }
    @Test
    public void testAlertsMessage(){
        driver.findElement(By.xpath("//*[@id='item-1']/span[contains(text(),'Alerts')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        List<WebElement> allAlertButtons=driver.findElements(By.id("javascriptAlertsWrapper"));
        if(allAlertButtons.size()!=0){
            for(WebElement link:allAlertButtons) {
                System.out.println(link.getText());
            }
        }
        // This step will result in an alert on screen
        driver.findElement(By.id("alertButton")).click();
        System.out.println("Clicked on button");
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println(simpleAlert.getText());
        simpleAlert.accept();
    }
    @Test
    public void testPromptAlert(){
        driver.findElement(By.xpath("//*[@id='item-1']/span[contains(text(),'Alerts')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        // This step will result in an alert on screen
        String mainWindow=driver.getWindowHandle();
        WebElement element = driver.findElement(By.id("promtButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert promptAlert  = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert text is " + alertText);
        //Send some text to the alert
        promptAlert.sendKeys("Test User");
        promptAlert.accept();
        driver.switchTo().window(mainWindow);
        System.out.println(driver.findElement(By.id("promptResult")).getText());
    }
    @Test
    public void testConfirmationAlert(){
            driver.findElement(By.xpath("//*[@id='item-1']/span[contains(text(),'Alerts')]")).click();
            if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
                this.closeAdds();
            }
        WebElement element = driver.findElement(By.id("confirmButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.accept();
        System.out.println("Accepted and closed");
    }
    @Test
    public void testUnexpectedAlert(){
        driver.findElement(By.xpath("//*[@id='item-1']/span[contains(text(),'Alerts')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        try {
            driver.findElement(By.id("timerAlertButton")).click();
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.accept();
            System.out.println("Unexpected alert accepted");
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }
    }
    @Test
    public void testFrames(){
        driver.findElement(By.xpath("//*[@id='item-2']/span[contains(text(),'Frames')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        //By executing a java script
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        int numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);

        //By finding all the web elements using iframe tag
        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are " + iframeElements.size());
        if(iframeElements.size()!=0){
            for (WebElement iFrame:iframeElements) {
                System.out.println("iFrame dimensions are " +iFrame.getSize());
                System.out.println(iFrame.getAccessibleName());
            }
        }
             }
    @Test
    public void testIFrames(){
     driver.findElement(By.xpath("//*[@id='item-2']/span[contains(text(),'Frames')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        driver.switchTo().frame(1);
        //Locate the frame1 heading
        WebElement frame1Heading= driver.findElement(By.id("sampleHeading"));

        //Finding the text of the frame1 heading
        String frame1Text=frame1Heading.getText();

        //Print the heading
        System.out.println("Text of the frame1 heading is:"+frame1Text);
    }
    @Test
    public void testNestedFrames(){
        driver.findElement(By.xpath("//*[@id='item-3']/span[contains(text(),'Nested Frames')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        //Number of Frames on a Page
        int countIframesInPage = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames on a Page:" + countIframesInPage);

        //Locate the frame1 on the webPage
        WebElement frame1=driver.findElement(By.id("frame1"));

        //Switch to Frame1
        driver.switchTo().frame(frame1);

        //Locate the Element inside the Frame1
        WebElement frame1Element= driver.findElement(By.tagName("body"));

        //Get the text for frame1 element
        String frame1Text=frame1Element.getText();
        System.out.println("Frame1 is :"+frame1Text);

        //Number of Frames on a Frame1
        int countIframesInFrame1 =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame1:" + countIframesInFrame1);

        //switch to child frame
        driver.switchTo().frame(0);

        int countIframesInFrame2 =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame2:" + countIframesInFrame2);

    }
    @Test
    public void testNestedFrameSwitching() throws Exception{
        driver.findElement(By.xpath("//*[@id='item-3']/span[contains(text(),'Nested Frames')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        //Number of Frames on a Page
        int countIframesInPage =driver. findElements(By. tagName("iframe")). size();
        System.out.println("Number of Frames on a Page:"+countIframesInPage);

        //Locate the frame1 on the webPage
        WebElement frame1=driver.findElement(By.id("frame1"));

        //Switch to Frame1
        driver.switchTo().frame(frame1);

        //Number of Frames on a Frame1
        int countIframesInFrame1 =driver. findElements(By. tagName("iframe")). size();
        System.out.println("Number of Frames inside the Frame1:"+countIframesInFrame1);

        //Switch to child frame
        driver.switchTo().frame(0);
        int countIframesInFrame2 =driver. findElements(By. tagName("iframe")). size();
        System.out.println("Number of Frames inside the Frame2:"+countIframesInFrame2);

        //Locate the Element inside the Frame1
        WebElement frame1Element= driver.findElement(By.tagName("body"));

        //Get the text for frame1 element
        String frame1Text=frame1Element.getText();

//        //Try to Print the text present inside parent frame
//        System.out.println("Frame1 is :"+frame1Text);
//
//        //Switch to Parent iFrame
//        driver.switchTo().parentFrame();
//        Thread.sleep(1000);
//        //Locate the Element inside the Frame1
//        WebElement frame2Element= driver.findElement(By.tagName("body"));
//
//        //Get the text for frame1 element
//        String frame2Text=frame1Element.getText();
//
//        //Try to Print the text present inside parent frame
//        System.out.println("Parent frame is :"+frame2Text);
    }
    @Test
    public void testModelDialogs() throws Exception{
        driver.get("https://demoqa.com/modal-dialogs");
        //driver.findElement(By.xpath("//*[@id=\"item-4\"]/span[contains(text(),'Modal Dialogs')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        //get parent window handle
        System.out.println(driver.findElement(By.className("main-header")).getText() +" this is the current page");
        driver.findElement(By.id("showSmallModal")).click();
        String parentWindow=driver.getWindowHandle();
        Set<String> allWindowHadnles=driver.getWindowHandles();
        for (String childWindow : allWindowHadnles) {
            if (!parentWindow.equalsIgnoreCase(childWindow)) {
                System.out.println("Inside if");
                driver.switchTo().window(childWindow);
                WebElement text = driver.findElement(By.className("modal-body"));
                System.out.println("Title of child window is: " + text.getText());
                driver.findElement(By.id("closeSmallModal")).click();
                System.out.println("dialog has been closed");
            }
        }

    }
    @After
    public void endTest(){
        driver.quit();
        System.out.println("----------------------------");
        System.out.println("Test has ended");
    }
}
