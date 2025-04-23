import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Elements1 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("before navigate");
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("paru");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("parameswarijittim@gmail.com");

        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();

        driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("8217380728");

        driver.findElement(By.xpath("(//input[@name='dob'])[1]")).sendKeys("09-04-2025");

        driver.findElement(By.xpath("//input[@name='subjects']")).sendKeys("Maths");

        driver.findElement(By.xpath("(//input[@class='form-check-input mt-0'])[6]")).click();

        String file_path="C:\\Users\\parameswari\\Desktop\\chiru pics";
        driver.findElement(By.xpath("//input[@class='form-check-input mt-0 file-input']")).sendKeys(file_path);

        driver.findElement(By.xpath("//textarea[@name='picture']")).sendKeys("sankranthipalli");
        WebElement element=driver.findElement(By.xpath("//select[@id='state']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Select dropdown = new Select(element);
        dropdown.selectByValue("Uttar Pradesh");

        WebElement element1=driver.findElement(By.xpath("//select[@id='city']"));

        Select dropdown1 = new Select(element1);
        dropdown1.selectByValue("Agra");
        WebElement element2=driver.findElement(By.xpath("//input[@type='submit']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(5000);














    }
}
