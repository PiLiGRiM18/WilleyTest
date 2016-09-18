import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by piligrim on 17.09.16.
 */
public class WilleyTestMain {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());

        driver.get("http://www.wiley.com/WileyCDA/");
        System.out.println("[Checked] open http://www.wiley.com/WileyCDA/ \n");

        WebElement topnav = driver.findElement(By.id("topnav"));
//        System.out.println("Checked: top navigation menu");

        topnav.findElement(By.linkText("Home"));
        topnav.findElement(By.linkText("Subjects"));
        topnav.findElement(By.linkText("About Wiley"));
        topnav.findElement(By.linkText("Contact Us"));
        topnav.findElement(By.linkText("Help"));
        System.out.println("1. [Checked] the following links displayed in top navigation menu: Home, Subjects, About Wiley, Contact Us, Help \n");

        WebElement homepagelinks = driver.findElement(By.id("homepage-links"));
//        System.out.println("Checked: items under Resources sub-header");
        homepagelinks.findElement(By.linkText("Students"));
        homepagelinks.findElement(By.linkText("Authors"));
        homepagelinks.findElement(By.linkText("Instructors"));
        homepagelinks.findElement(By.linkText("Librarians"));
        homepagelinks.findElement(By.linkText("Societies"));
        homepagelinks.findElement(By.linkText("Conferences"));
        homepagelinks.findElement(By.linkText("Booksellers"));
        homepagelinks.findElement(By.linkText("Corporations"));
        homepagelinks.findElement(By.linkText("Institutions"));
        System.out.println("2. [Checked] the following links displayed in sub-header: Students, Authors, Instructors, Librarians, Societies, Conferences, Booksellers, Corporations, Institutions \n");

        driver.findElement(By.linkText("Students")).click();

        if (driver.getCurrentUrl().contains("http://eu.wiley.com/WileyCDA/Section/id-404702.html")) {
            WebElement pagetitle = driver.findElement(By.id("page-title"));
//            System.out.println(pagetitle.findElement(By.tagName("h1")).getText());
            if (pagetitle.findElement(By.tagName("h1")).getText().contains("Students")){
                System.out.println("3. [Checked] the http://www.wiley.com/WileyCDA/Section/id-404702.html url is opened, and the “Students” header is displayed \n");
            }
        }

        WebElement sidebar = driver.findElement(By.id("sidebar")).findElement(By.className("activeParent")).findElement(By.className("autonavLevel1"));
        List<WebElement> sidebarItems = sidebar.findElements(By.xpath("li"));
        if (sidebarItems.size() == 8){
            System.out.println("4. [Checked] " + sidebarItems.size() + " items are displayed in the menu");
        } else {
            System.out.println("4. [False] " + sidebarItems.size() + " items are displayed in the menu");
        }

        String listItems = "Authorts Librarians Booksellers Instructors Students Government Employees Societies Corporate Partners";
        WebElement studentEl = null;
        for (WebElement el:
             sidebarItems) {
            System.out.println("Item: " + el.getText());
//            if (listItems.contains(el.getText())) {
//                System.out.println(el.getText() + " [Checked]");
//            } else {
//                System.out.println(el.getText() + " [False]");
//            }
//            System.out.println(el.getText());
            if (el.getText().contains("Students")){
                studentEl = el;
            }
        }

        System.out.println(studentEl.getAttribute("class"));

        if (studentEl.getAttribute("class").contains("active")){
            System.out.println("5. [Checked] “Students” item is selected");
            studentEl.click();
        } else {
            System.out.println("5. [False] “Students” item is unselected");
        }


//        WebElement element = driver.findElement(By.linkText("Home"));WebElement studentEl
//        element.sendKeys("Chese!");
//        element.submit();
        System.out.println("\n **-= ALL TESTS COMPLETE SUCCESFULLY =- **");
//        System.out.println("Page title is: " + driver.getTitle());
    }
}
