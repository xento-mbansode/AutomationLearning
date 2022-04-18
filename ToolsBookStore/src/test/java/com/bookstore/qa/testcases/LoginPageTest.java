package com.bookstore.qa.testcases;

import com.bookstore.qa.base.TestBase;
import com.bookstore.qa.pages.BooksPage;
import com.bookstore.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    BooksPage booksPage;

    LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage= new LoginPage();
    }
    @Test (priority = 1)
    public void loginPageTitleTest(){
       String title= loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"ToolsQA");
    }
    @Test (priority = 2)
    public void loginTest(){
       booksPage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
