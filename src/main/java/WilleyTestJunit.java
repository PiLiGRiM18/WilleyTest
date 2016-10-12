import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by PiLiGRiM on 12.10.2016.
 */
public class WilleyTestJunit {
    WebDriver driver = new ChromeDriver();
    @Test
    public void Action1 (){
        driver.get("http://www.wiley.com/WileyCDA/");
        WebElement topnav = driver.findElement(By.id("topnav"));
        Assert.assertEquals("Home", topnav.findElement(By.linkText("Home")).getText());
        Assert.assertEquals("Subjects", topnav.findElement(By.linkText("Subjects")).getText());
        Assert.assertEquals("About Wiley", topnav.findElement(By.linkText("About Wiley")).getText());
        Assert.assertEquals("Contact Us", topnav.findElement(By.linkText("Contact Us")).getText());
        Assert.assertEquals("Help", topnav.findElement(By.linkText("Help")).getText());
    }
}
