package Task_11.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class HomePage {
    private WebDriver driver;

    public static final String URL = "https://www.demoblaze.com/index.html";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        if (!URL.equals(driver.getCurrentUrl())) {
            driver.get(URL);
        }
    }

    public HomePage open() {
        driver.get(URL);
        return this;
    }

    public LoginPage openLoginPage() {
        WebElement loginButton = driver.findElement(By.cssSelector("#login2"));
        loginButton.click();
        return new LoginPage(driver);
    }

    public boolean isLoggedIn(String userName) {
        WebElement userNameOnPage = driver.findElement(By.cssSelector("#nameofuser"));
        return userName.equals(userNameOnPage.getText());
    }
}
