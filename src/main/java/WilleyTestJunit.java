import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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
        driver.quit();
    }

    @Test
    public void Action2 () {
        driver.get("http://www.wiley.com/WileyCDA/");
        WebElement homepagelinks = driver.findElement(By.id("homepage-links"));
        List<WebElement> homepagelinksList = homepagelinks.findElements(By.tagName("li"));
        Assert.assertEquals(homepagelinksList.size(), 9);

        Assert.assertEquals("Students", homepagelinks.findElement(By.linkText("Students")).getText());
        Assert.assertEquals("Authors", homepagelinks.findElement(By.linkText("Authors")).getText());
        Assert.assertEquals("Instructors", homepagelinks.findElement(By.linkText("Instructors")).getText());
        Assert.assertEquals("Librarians", homepagelinks.findElement(By.linkText("Librarians")).getText());
        Assert.assertEquals("Societies", homepagelinks.findElement(By.linkText("Societies")).getText());
        Assert.assertEquals("Conferences", homepagelinks.findElement(By.linkText("Conferences")).getText());
        Assert.assertEquals("Booksellers", homepagelinks.findElement(By.linkText("Booksellers")).getText());
        Assert.assertEquals("Corporations", homepagelinks.findElement(By.linkText("Corporations")).getText());
        Assert.assertEquals("Institutions", homepagelinks.findElement(By.linkText("Institutions")).getText());
        driver.quit();
    }
}
