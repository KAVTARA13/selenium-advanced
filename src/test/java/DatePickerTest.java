import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;


public class DatePickerTest {
    @Test
    public void exeption() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://jqueryui.com/datepicker/");
        try {
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]")));
        } catch (NoSuchFrameException e){
            System.out.println(e);
        }
        WebElement button = driver.findElement(By.xpath("//input[@id=\"datepicker\"]"));
        button.click();

        WebElement previous = driver.findElement(By.xpath("//a[@class=\"ui-datepicker-prev ui-corner-all\"]"));
        previous.click();

        List<WebElement> link = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]/tbody//a"));
        int lastday= link.size();
        WebElement day = driver.findElement(By.xpath("//table[@class=\"ui-datepicker-calendar\"]/tbody//a[text()='"+lastday+"']"));
        day.click();
    }
}
