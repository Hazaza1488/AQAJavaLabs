package org.example.task_11.bo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.example.Task_11.po.ProductPage;
import org.example.Task_11.po.HomePage;
import org.example.Task_11.po.LoginPage;
import org.example.Task_11.po.ProfilePage;

public class BO {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private ProductPage productPage;

    private static final String USERNAME = "123user123";
    private static final String PASSWORD = "user1234";


    public BO(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.productPage = new ProductPage(driver);
        this.profilePage = new ProfilePage(driver);
    }

    public BO login() throws InterruptedException {
        homePage.openLoginPage();
        Assert.assertTrue(loginPage.isOpen());

        loginPage.enterUserName(USERNAME).enterPassword(PASSWORD).submit();

        Thread.sleep(1000);
        Assert.assertTrue(homePage.isLoggedIn(USERNAME));

        return this;
    }


    public BO addProductToCollection() throws InterruptedException {
        homePage.open().openProductPage();
        if (!productPage.isOpen()) Thread.sleep(1000);
        Assert.assertTrue(productPage.isOpen());
        productPage.addProductToCollection();

        Thread.sleep(1000);
        Assert.assertTrue(productPage.isProductAdded());
        driver.switchTo().alert().accept();

        return this;
    }

    public void openCollectionPage() {
        profilePage.open();
    }
}