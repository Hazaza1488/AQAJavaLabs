package org.example.Task_11.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class LoginPage {
    private WebDriver driver;

    public static final String URL = "https://www.demoblaze.com/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public boolean isOpen() {
        return URL.equals(driver.getCurrentUrl());
    }

    public LoginPage enterUserName(String userName) {
        WebElement userNameInput = driver.findElement(By.cssSelector("#userName"));
        userNameInput.sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.sendKeys(password);
        return this;
    }

    public void submit() {
        WebElement loginButton = driver.findElement(By.cssSelector("#login"));
        loginButton.click();
    }
}
