package Task_11.PO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpen() {
        return driver.getCurrentUrl().contains("?product=");
    }

    public void addProductToCollection() {
        WebElement addToCollections = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
        addToCollections.click();
    }

    public boolean isProductAdded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();
        return "Product added to your cart.".equals(alertText);
    }
}
