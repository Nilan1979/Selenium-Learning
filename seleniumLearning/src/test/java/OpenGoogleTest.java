import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenGoogleTest {

    //open google
    //go to google home page
    @Test
    public void googleTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("colombo" + Keys.ENTER);
    }
}
