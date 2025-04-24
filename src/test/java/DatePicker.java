import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DatePicker {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("before navigate");
        driver.get("https://jqueryui.com/datepicker/");
        Thread.sleep(3000);

        driver.switchTo().frame(0);

        //using date picker

        String year="2025";
        String month="May";


        String date="20";

        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        while(true)
        {
            String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();


            if(currentMonth.equals(month)  &&  currentYear.equals(year))
            {
                break;
            }

        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

        }
        List<WebElement>  allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for(WebElement dt:allDates){
            if(dt.getText().equals(date)){

                dt.click();
                break;
            }
        }
        Thread.sleep(3000);



    }
}
