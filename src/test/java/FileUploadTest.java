import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.awt.*;

public class FileUploadTest {
    @Test
    public void upload() throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://the-internet.herokuapp.com/upload");
        try {
        WebElement choose= driver.findElement(By.id("file-upload"));
        choose.sendKeys("c:\\Users\\User\\Desktop\\img.jpg");

        WebElement upload= driver.findElement(By.id("file-submit"));
        upload.click();
        } catch(StaleElementReferenceException e) {
            System.out.println(e);
        }
    }
}
