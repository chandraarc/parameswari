import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_1 {




    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver=WebDriverManager.chromedriver().capabilities(options).create();
       // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("before navigate");
        driver.get("https://www.flipkart.com/");
        System.out.println("before click");
       // driver.switchTo().newWindow(WindowType.TAB);
       // driver.get("http://google.com");
        System.out.println("before click");
       // driver.findElement(By.xpath("//img[@alt='Mobiles']")).click();
       // System.out.println("after click");
        Thread.sleep(10000);


        driver.quit();

    }
}
