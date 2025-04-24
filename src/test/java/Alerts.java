import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("before navigate");
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");

        driver.findElement(By.xpath("//button[text()='Alert']")).click();
        Thread.sleep(3000);
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println(simpleAlert.getText());
        Thread.sleep(2000);
        simpleAlert.accept();
        Thread.sleep(2000);
        driver.quit();


        driver.findElement(By.xpath("(//button[text()='Click Me'])[2]")).click();
        Thread.sleep(3000);
        Alert confirmationAlert = driver.switchTo().alert();
        System.out.println(confirmationAlert.getText());
        Thread.sleep(2000);
        confirmationAlert.dismiss();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div[text()='You pressed Cancel!']")).getText());
        driver.quit();


        driver.findElement(By.xpath("(//button[text()='Click Me'])[3]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("test");
        System.out.println(promptAlert.getText());
        Thread.sleep(5000);
        promptAlert.accept();
        Thread.sleep(5000);


    }
}
