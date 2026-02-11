import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Linkexample {

    WebDriver driver;

    @BeforeMethod
    public void  openLinkTestPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void linkTests(){

        //01 Take me to dashboard

        WebElement linkhome  = driver.findElement(By.linkText("Go to Dashboard"));
        linkhome.click();
        driver.navigate().back();

        //02 Find my destination

        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL without"));
        String path = wheretoGo.getAttribute("href");
        System.out.println("this link is going to "+ path);

        //03 Am I broken link?

        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("the link is broken");
        }else {
            System.out.println("Link is not broken");
        }
        driver.navigate().back();


        //04 Duplicate Link
        WebElement linkhome1  = driver.findElement(By.linkText("Go to Dashboard"));
        linkhome1.click();
        driver.navigate().back();

        //05 Count Links

        List<WebElement> countFullPageLinks = driver.findElements(By.tagName("a"));
        int pagelinkCount = countFullPageLinks.size();
        System.out.println("Count of full page links " +pagelinkCount);

        //06 Count Layout Links

        WebElement layoutElements = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLinks  =layoutElements.findElements(By.tagName("a"));
        System.out.println("count of layout links "+countOfLayoutLinks.size());
    }
}
