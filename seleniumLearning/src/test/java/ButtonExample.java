import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod
    public void  openLinkTestPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        Dimension newSize = new Dimension(800,600);
//        driver.manage().window().setSize(newSize);
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTest(){
        //Click and Confirm title.

        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Actual title same as expected");
        } else {
            System.out.println("Actual title not same as expected");
        }

        //Assert.assertEquals(actualTitle,expectedTitle,"title miss matched");
        driver.navigate().back();
        //Find the position of the Submit button
        WebElement getPosition = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt94']"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X position is "+ x + "Y position is "+ y);

        //Find the Save button color
        WebElement buttonColor = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt96']"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println("Button color is " + color);

        //Find the height and width of this button
        WebElement size = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Height "+ height + "Width "+width);

    }
}
