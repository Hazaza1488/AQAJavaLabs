package Task_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumStart {
    public static void main(String[] args) {

        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/elements");

        WebElement navItem = driver.findElement(By.xpath("//*[@id=\"itemc\"]"));
        navItem.click();

        WebElement img = driver.findElement(By.xpath("//*[@id=\"article\"]"));
        System.out.println(img.getSize());
        System.out.println(img.getAttribute("src"));

        WebElement practiceForm = driver.findElement(By.xpath("//*[@id=\"carouselExampleIndicators\"]/a[2]/span[1]"));
        practiceForm.click();

        WebElement form = driver.findElement(By.xpath("//*[@id=\"prev2\"]"));
        navItem.click();

        form = driver.findElement(By.xpath("//*[@id=\"prev2\"]"));
        navItem.click();

        driver.close();
        driver.quit();
    }
}
