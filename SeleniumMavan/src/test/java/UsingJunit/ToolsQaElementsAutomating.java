package UsingJunit;

import org.junit.*;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.sound.midi.Soundbank;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ToolsQaElementsAutomating {
    WebDriver driver;

    //close the add
    public void closeAdds(){
        driver.findElement(By.cssSelector("#close-fixedban")).click();
        System.out.println("add closed");
    }
    public static void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() >= 400) {
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }

            //Fetching and Printing the response code obtained
            else {
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Before
    public void setup(){
        String url="https://demoqa.com";
        System.setProperty("webdriver.chrome.driver","/C:/Dependancy/chromedriver_win32/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("-----------Test Started------------");
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1) > div > div.card-body")).click();
        System.out.println(driver.findElement(By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > span > div > div.header-text")).isDisplayed());
    }

//    @Test
//    public void elementsMenu() {
//        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1) > div > div.card-body")).click();
//        System.out.println(driver.findElement(By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > span > div > div.header-text")).isDisplayed());
//    }
    @Test
       public void testTextBoxes(){
        driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")).click();
        this.closeAdds();
        //code to play with Text fields
        driver.findElement(By.cssSelector("#userName")).sendKeys("Makrand Bansode");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("makban@gmail.com");
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Dreams Nandini, Shewalewadi, Manjri, Pune");
        driver.findElement(By.cssSelector("#permanentAddress")).sendKeys("Dreams Nandini, Shewalewadi, Manjri, Pune");
        driver.findElement(By.cssSelector("#submit")).click();
        System.out.println("Completed TextBoxes");
      }
    @Test
    public void testCheckBoxes(){
        driver.findElement(By.xpath("//span[contains(text(),'Check Box')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        System.out.println(driver.findElement(By.cssSelector("#tree-node")).isDisplayed());
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > button > svg")).click();
        System.out.println("Clicked and expanded "+driver.findElement(By.cssSelector("#tree-node > ol > li > span > button > svg")).getText());
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > button > svg")).click();
        System.out.println("Clicked and expanded" +driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > button > svg")).getText());
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(2) > span > label")).click();
 //       String lableTitle=driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(2) > span > label")).getTagName();
        driver.findElement(By.cssSelector("#result > span.text-success")).isDisplayed();
//        String dispLable=driver.findElement(By.cssSelector("#result > span.text-success")).getText();
//        System.out.println("Title of checked check box is matched with displayed title" +lableTitle.equals(dispLable));
        //listing out all web-elements inside tag name
        driver.navigate().refresh();
        //driver.get("https://demoqa.com/checkbox");
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        driver.findElement(By.cssSelector("#tree-node > div > button.rct-option.rct-option-expand-all")).click();

        List<WebElement> allCheckBoxes=driver.findElements(By.className("rct-title"));
        if(allCheckBoxes.size() !=0){
            System.out.println(allCheckBoxes.size() + " Elements found by ClassName \n");
            for (WebElement chekBox:allCheckBoxes){
                System.out.println(chekBox.getText());
            }
        }

    }
    @Test
    public void testRadioButtons(){
        //code to test radio buttons
        driver.findElement(By.xpath("//span[contains(text(),'Radio Button')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        List<WebElement> allRadioButtons=driver.findElements(By.className("custom-control-label"));
        if(allRadioButtons.size() !=0){
            System.out.println(allRadioButtons.size() + " Elements found by ClassName \n");
            for (WebElement radioButton:allRadioButtons){
                System.out.println(radioButton.getText());
            }
        }
        driver.findElement(By.xpath("//*/label[contains(text(),'Yes')]")).click();
        String s1=driver.findElement(By.xpath("//*/label[contains(text(),'Yes')]")).getText();
        String s2=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span")).getText();

        System.out.println("Select vs displayed are matached ? " +s1.equals(s2));
        System.out.println("Completed Radio button test");
    }
    @Test
    public void testWebTable() throws InterruptedException {
        //code to test radio buttons
        driver.findElement(By.xpath("//span[contains(text(),'Web Tables')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        List<WebElement> tableHeaders=driver.findElements(By.className("rt-tr"));
        if(tableHeaders.size() !=0){
            System.out.println(tableHeaders.size() + " Web Elements found by ClassName \n");
            for (WebElement header:tableHeaders){
                System.out.println(header.getText());
            }
        }
        driver.findElement(By.cssSelector("#addNewRecordButton")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector("#registration-form-modal")).isDisplayed());
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Mak");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Ban");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("mak.ban@gmail.com");
        driver.findElement(By.cssSelector("#age")).sendKeys("25");
        driver.findElement(By.cssSelector("#salary")).sendKeys("15000");
        driver.findElement(By.cssSelector("#department")).sendKeys("QA");
        driver.findElement(By.cssSelector("#submit")).click();

        List<WebElement> tableHeadersAfter=driver.findElements(By.className("rt-tr"));
        if(tableHeadersAfter.size() !=0){
            System.out.println(tableHeadersAfter.size() + " Web Elements found by ClassName \n");
            for (WebElement headerA:tableHeadersAfter){
                System.out.println(headerA.getText());
            }
        }
        //code to delete 2nd element from the list
        System.out.println("Rcords with below details will be delted");
        List<WebElement>eleToBeDelete=driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[2]/div"));
        if(eleToBeDelete.size() !=0){
            for (WebElement delete:eleToBeDelete) {
                System.out.println(delete.getText());
            }
        }
        driver.findElement(By.cssSelector("#delete-record-2")).click();

    }
    @Test
    public void testButtons(){
        //code to test radio buttons
        driver.findElement(By.xpath("//span[contains(text(),'Buttons')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        List<WebElement> allButtons=driver.findElements(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2)"));
        if(allButtons.size() !=0){
            System.out.println("Buttons found the Page");
            for (WebElement button:allButtons) {
                System.out.println(button.getText());
            }
        }
          //code for double click on page
       Actions act =new Actions(driver);
       WebElement dButton=driver.findElement(By.cssSelector("#doubleClickBtn"));
       act.doubleClick(dButton).perform();
       System.out.println(driver.findElement(By.cssSelector("#doubleClickMessage")).isDisplayed());
       System.out.println(driver.findElement(By.cssSelector("#doubleClickMessage")).getText());

       //code for right click
        WebElement rClick= driver.findElement(By.cssSelector("#rightClickBtn"));
        act.contextClick(rClick).perform();
        System.out.println(driver.findElement(By.cssSelector("#rightClickMessage")).isDisplayed());
        System.out.println(driver.findElement(By.cssSelector("#rightClickMessage")).getText());
    }
    @Test
    public void testLinks() throws Exception{
        driver.findElement(By.xpath("//span[contains(text(),'Links')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
        List<WebElement> pageLinks=driver.findElements(By.id("linkWrapper"));
        if(pageLinks.size() !=0){
            for(WebElement link:pageLinks){
                System.out.println(link.getText());
            }
        }
        String mainWindowHandle= driver.getWindowHandle();
        System.out.println(driver.getTitle() + " is the Current page");
        driver.findElement(By.cssSelector("#simpleLink")).click();
        Thread.sleep(1000);
        Set<String> allWindowHandles=driver.getWindowHandles();
        Iterator<String> it=allWindowHandles.iterator();
        while(it.hasNext()) {
            String childWindow = it.next();
            if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
                System.out.println(driver.getTitle() + " is the Current page");
                driver.switchTo().window(childWindow);
                System.out.println(driver.getCurrentUrl());
                System.out.println(driver.getTitle());
            }
        }
        driver.switchTo().window(mainWindowHandle);
        driver.getTitle();
       // driver.findElement(By.cssSelector("#dynamicLink"));
    }
    @Test
    public void testBrokenLinkAndImage(){
        driver.findElement(By.xpath("//span[contains(text(),'Broken Links - Images')]")).click();
        if(driver.findElement(By.cssSelector("#close-fixedban")).isDisplayed()){
            this.closeAdds();
        }
       List<WebElement> images=driver.findElements(By.tagName("img"));
        System.out.println("Total number of Images on the page are: " +images.size());

        for(int i=0;i<images.size();i++){
            WebElement image=images.get(i);
            String imageUrl=image.getAttribute("src");
            System.out.println(" URL of Image " +(i+1) + " is: " +imageUrl);
            verifyLinks(imageUrl);

            try{
                boolean imageDisplayed=(Boolean)((JavascriptExecutor)driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
                if(imageDisplayed){
                    System.out.println("--------DISPLAY -OK---------");
                }else {
                    System.out.println("--------DISPLAY -BROKEN---------");
                }
            }catch (Exception e){
                System.out.println("Error Occured");
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
