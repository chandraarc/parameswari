import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WebTables {
    public static void main(String[] args) throws InterruptedException, IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("before navigate");
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");

        List<WebElement>allHeaders=driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/thead/tr/th"));
        //System.out.println("Total count of headers "+allHeaders.size());
        List<String> headers = new ArrayList<>();
        for(WebElement ele1:allHeaders){
            headers.add(ele1.getText().toUpperCase(Locale.ROOT));
        }

        List<Employee1> employee1s = new ArrayList<>();

        Employee1 employee1 = new Employee1();
        employee1.setFirstName(allHeaders.get(0).getText());
        employee1.setLastName(allHeaders.get(1).getText());
        employee1.setAge(allHeaders.get(2).getText());
        employee1.setEmail(allHeaders.get(3).getText());
        employee1.setSalary(allHeaders.get(4).getText());
        employee1.setDepartment(allHeaders.get(5).getText());
        employee1s.add(employee1);


        List<WebElement>numberOfRows=driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr"));
//        System.out.println("Total count of rows "+numberOfRows.size());



        for(WebElement ele1:numberOfRows){
            List<WebElement>datavalues=ele1.findElements(By.xpath(".//td"));
            employee1 = new Employee1();
            employee1.setFirstName(datavalues.get(0).getText());
            employee1.setLastName(datavalues.get(1).getText());
            employee1.setAge(datavalues.get(2).getText());
            employee1.setEmail(datavalues.get(3).getText());
            employee1.setSalary(datavalues.get(4).getText());
            employee1.setDepartment(datavalues.get(5).getText());
            employee1s.add(employee1);


        }
        Writer writer = new FileWriter("employee.csv");

        ColumnPositionMappingStrategy<Employee1> mappingStrategy = new ColumnPositionMappingStrategy<>();
        mappingStrategy.setType(Employee1.class);

        StatefulBeanToCsv<Employee1> beanToCsv = new StatefulBeanToCsvBuilder<Employee1>(writer)
                .withMappingStrategy(mappingStrategy)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        beanToCsv.write(employee1s);
        writer.close();
        Thread.sleep(5000);
    }
}

