package Task_11.BO;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Task_11.PO.ProductPage;
import Task_11.PO.HomePage;
import Task_11.PO.LoginPage;
import Task_11.PO.ProfilePage;

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
        homePage.open().openLoginPage();
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
