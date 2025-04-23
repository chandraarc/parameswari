import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Elements2 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("before navigate");
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");

        driver.findElement(By.xpath("(//button[@class='accordion-button collapsed'])[1]")).click();

        driver.findElement(By.xpath("//div/ul/li[@class='list-group-item active']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("paru");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("paru.jettim@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("Bangalore");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("paru");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);





    }
}

