import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by piligrim on 17.09.16.
 */
public class WilleyTestMain {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());

        driver.get("http://www.wiley.com/WileyCDA/");
        System.out.println("Checked: open http://www.wiley.com/WileyCDA/");

        WebElement topnav = driver.findElement(By.id("topnav"));
        System.out.println("Checked: top navigation menu");

        topnav.findElement(By.linkText("Home"));
        topnav.findElement(By.linkText("Subjects"));
        topnav.findElement(By.linkText("About Wiley"));
        topnav.findElement(By.linkText("Contact Us"));
        topnav.findElement(By.linkText("Help"));
        System.out.println("1. [Checked] the following links displayed in top navigation menu: Home, Subjects, About Wiley, Contact Us, Help");

        WebElement homepagelinks = driver.findElement(By.id("homepage-links"));
        System.out.println("Checked: items under Resources sub-header");
        homepagelinks.findElement(By.linkText("Students"));
        homepagelinks.findElement(By.linkText("Authors"));
        homepagelinks.findElement(By.linkText("Instructors"));
        homepagelinks.findElement(By.linkText("Librarians"));
        homepagelinks.findElement(By.linkText("Societies"));
        homepagelinks.findElement(By.linkText("Conferences"));
        homepagelinks.findElement(By.linkText("Booksellers"));
        homepagelinks.findElement(By.linkText("Corporations"));
        homepagelinks.findElement(By.linkText("Institutions"));
        System.out.println("2. [Checked] the following links displayed in sub-header: Students, Authors, Instructors, Librarians, Societies, Conferences, Booksellers, Corporations, Institutions");

//        WebElement element = driver.findElement(By.linkText("Home"));
//        element.sendKeys("Chese!");
//        element.submit();
        System.out.println("All tests complete successfully");
//        System.out.println("Page title is: " + driver.getTitle());
    }
}
