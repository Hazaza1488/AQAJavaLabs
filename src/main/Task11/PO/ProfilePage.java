package org.example.Task_11.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class ProfilePage {
    private WebDriver driver;

    public static final String URL = "https://www.demoblaze.com/index.html#";

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public ProfilePage open() {
        driver.get(URL);
        return this;
    }

    public boolean isOpen() {
        return URL.equals(driver.getCurrentUrl());
    }

    public void clearCollection() throws InterruptedException {
        WebElement clearCollectionButton = driver.findElement(By.id("nameofuser"));
        clearCollectionButton.click();
        Thread.sleep(1000);
    }
}
