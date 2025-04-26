import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Slider {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("before navigate");
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

        Actions act=new Actions(driver);
        WebElement min_slider=driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));

        System.out.println("Location of the minimum slider:"+min_slider.getLocation());//(58,249)
        act.dragAndDropBy(min_slider,100,249).perform();
        Thread.sleep(4000);

        System.out.println("Location of the minimum slider after moving:"+min_slider.getLocation());

        WebElement max_slider=driver.findElement(By.xpath("//div[@class='price-range-block']//span[2]"));

        System.out.println("Location of the maximum slider:"+max_slider.getLocation());//(876,249)
        Thread.sleep(4000);
        act.dragAndDropBy(max_slider,-100,249).perform();
        Thread.sleep(4000);
        System.out.println("Location of the maximum slider after moving:"+max_slider.getLocation());//(876,249)


    }
}


