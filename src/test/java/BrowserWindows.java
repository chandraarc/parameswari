import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;

public class BrowserWindows {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("before navigate");
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
        driver.findElement(By.xpath("//button[@title='New Tab']")).click();

        driver.findElement(By.xpath("//button[text()='New Window']")).click();


        driver.findElement(By.xpath("//button[text()='New Window Message']")).click();
        Thread.sleep(3000);
    }

}
