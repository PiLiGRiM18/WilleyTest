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
        driver.get("http://www.google.com");

        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("Chese!");

        element.submit();

        System.out.println("Page title is: " + driver.getTitle());
    }
}
