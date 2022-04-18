package com.bookstore.qa.pages;

import com.bookstore.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page factory - Object Repository
    @FindBy(id="userName")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id ="newUser")
    WebElement newUserButton;

    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }
    public BooksPage login(String un,String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();

        return new BooksPage();
    }

}
