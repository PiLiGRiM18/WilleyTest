import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by piligrim on 17.09.16.
 */
public class WilleyTestMain {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
        driver.get("http://www.google.com");
        int countCheck = 0;
        int countFail = 0;

        // Action 1
        try {
            driver.get("http://www.wiley.com/WileyCDA/");
            WebElement topnav = driver.findElement(By.id("topnav"));
            topnav.findElement(By.linkText("Home"));
            topnav.findElement(By.linkText("Subjects"));
            topnav.findElement(By.linkText("About Wiley"));
            topnav.findElement(By.linkText("Contact Us"));
            topnav.findElement(By.linkText("Help"));
            System.out.println("ACTION 1:\n" +
                    "Open http://www.wiley.com/WileyCDA/\n" +
                    "Check the following links displayed in top navigation menu\n" +
                    "Home\n" +
                    "Subjects\n" +
                    "About Wiley\n" +
                    "Contact Us\n" +
                    "Help\n" +
                    "Action 1 CHECKED!\n");
            countCheck++;
        } catch (Exception e) {
            System.out.println("Action 1 FAILED!\n");
            countFail++;
            e.printStackTrace();
        }

        // Action 2
        try {
            WebElement homepagelinks = driver.findElement(By.id("homepage-links"));
            List<WebElement> homepagelinksList = homepagelinks.findElements(By.tagName("li"));
            if (homepagelinksList.size() == 9) {
                try {
                    homepagelinks.findElement(By.linkText("Students"));
                    homepagelinks.findElement(By.linkText("Authors"));
                    homepagelinks.findElement(By.linkText("Instructors"));
                    homepagelinks.findElement(By.linkText("Librarians"));
                    homepagelinks.findElement(By.linkText("Societies"));
                    homepagelinks.findElement(By.linkText("Conferences"));
                    homepagelinks.findElement(By.linkText("Booksellers"));
                    homepagelinks.findElement(By.linkText("Corporations"));
                    homepagelinks.findElement(By.linkText("Institutions"));
                    System.out.println("ACTION 2:\n" +
                            "Check items under Resources sub-header\n" +
                            "There are 9 items under resources sub-header\n" +
                            "Titles are “Students”, “Authors”, “Instructors”, “Librarians”, “Societies”, “Conferences”, “Booksellers”, “Corporations”, “Institutions”\n" +
                            "Action 2 CHECKED!\n");
                    countCheck++;
                } catch (Exception e) {
                    System.out.println("Action 2 FAILED!\n");
                    countFail++;
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println("Action 2 FAILED!\n");
            countFail++;
            e.printStackTrace();
        }

        // Action 3
        try {
            driver.findElement(By.linkText("Students")).click();
            if (driver.getCurrentUrl().contains("http://eu.wiley.com/WileyCDA/Section/id-404702.html")) {
                WebElement pagetitle = driver.findElement(By.id("page-title"));
                if (pagetitle.findElement(By.tagName("h1")).getText().contains("Students")) {
                    System.out.println("ACTION 3:\n" +
                            "Click “Students” item\n" +
                            "Check that http://www.wiley.com/WileyCDA/Section/id-404702.html url is opened\n" +
                            "Check that “Students” header is displayed\n" +
                            "Action 3 CHECKED!\n");
                    countCheck++;
                }
            }
        } catch (Exception e) {
            System.out.println("Action 3 FAILED!\n");
            countFail++;
            e.printStackTrace();
        }

        // Action 4
        try {
            WebElement sidebar = driver.findElement(By.id("sidebar")).findElement(By.className("activeParent")).findElement(By.className("autonavLevel1"));
            List<WebElement> sidebarItems = sidebar.findElements(By.xpath("li"));
            if (sidebarItems.size() == 8) {
                try {
                    sidebar.findElement(By.linkText("Authorts"));
                    sidebar.findElement(By.linkText("Librarians"));
                    sidebar.findElement(By.linkText("Booksellers"));
                    sidebar.findElement(By.linkText("Instructors"));
                    sidebar.findElement(By.linkText("Students"));
                    sidebar.findElement(By.linkText("Government Employees"));
                    sidebar.findElement(By.linkText("Societies"));
                    sidebar.findElement(By.linkText("Corporate Partners"));
                    System.out.println("Action 4:\n" +
                            "Check “Resources For” menu on the left\n" +
                            "8 items are displayed in the menu\n" +
                            "Items are “Authorts”, “Librarians”, “Booksellers”, “Instructors”, “Students” ,”Government Employees”, “Societies”, “Corporate Partners”\n" +
                            "Action 4 CHECKED!\n");
                    countCheck++;
                } catch (Exception e) {
                    System.out.println("Action 4 FAILED!\n");
                    countFail++;
                    e.printStackTrace();
                }
            } else {
                System.out.println("Action 4:\n" +
                        "There is no 8 items are displayed in the menu, it`s "+ sidebarItems.size() + "\n" +
                        "Action 4 FAILED!\n");
                countFail++;
            }
        } catch (Exception e) {
            System.out.println("Action 4 FAILED!\n");
            countFail++;
            e.printStackTrace();
        }

        // Action 5
        try {
            WebElement sidebar = driver.findElement(By.id("sidebar")).findElement(By.className("activeParent")).findElement(By.className("autonavLevel1"));
            WebElement studentItem = sidebar.findElement(By.className("active"));
            if (studentItem.getText().contains("Students")) {
                try {
                    studentItem.click();
                    System.out.println("Action 5:\n" +
                            "“Students” item is clickable\n" +
                            "Action 5 FAILED!\n");
                    countFail++;
                } catch (Exception e) {
                    // TODO: is classname "active" different style?
                    System.out.println("Action 5:\n" +
                            "Check “Students” item is selected\n" +
                            "“Students” item has different style\n" +
                            "“Students” item is not clickable\n" +
                            "Action 5 CHECKED!\n");
                    countCheck++;
                }
            } else {
                System.out.println("Action 5:\n" +
                        "“Students” item is not selected\n" +
                        "Action 5 FAILED!\n");
                countFail++;
            }
        } catch (Exception e) {
            System.out.println("Action 5 FAILED!\n");
            countFail++;
            e.printStackTrace();
        }

        // Action 6
        try {
            WebElement home = driver.findElement(By.linkText("Home"));
            home.click();
            System.out.println("Action 6:\n" +
                    "Click “Home” link at the top navigation menu\n" +
                    "Action 6 CHECKED!\n");
            countCheck++;
        } catch (Exception e) {
            System.out.println("Action 6 FAILED!\n");
            countFail++;
            e.printStackTrace();
        }

        // Action 7
        try {
            WebElement emailAddressUnput = driver.findElement(By.name("EmailAddress"));
            driver.findElement(By.name("submitButton")).click();
            Alert alertForCleanEmailField = driver.switchTo().alert();
            if (alertForCleanEmailField.getText().contains("Please enter email address")) {
                System.out.println("Action 7:\n" +
                        "Find “Sign up to receive Wiley updates” line and input field next to it. Do not enter anything and click arrow button\n" +
                        "Check that alert appeared\n" +
                        "Check that alert text is “Please enter email address”\n" +
                        "Action 7 CHECKED!\n");
                countCheck++;
            } else {
                System.out.println("Action 7:\n" +
                        "the alert text is not “Please enter email address” its " + "“" + alertForCleanEmailField.getText() + "”\n" +
                        "Action 7 FAILED!\n");
                countFail++;
            }
            alertForCleanEmailField.accept();
        } catch (Exception e) {
            System.out.println("Action 7 FAILED!\n");
            countFail++;
            e.printStackTrace();
        }

        // Action 8
        try {
            WebElement emailAddressUnput = driver.findElement(By.name("EmailAddress"));
            emailAddressUnput.sendKeys("invalidemail.ru");
            driver.findElement(By.name("submitButton")).click();
            Alert alertForInvalidEmailField = driver.switchTo().alert();

            if (alertForInvalidEmailField.getText().contains("Invalid email address.")) {
                System.out.println("Action 8:\n" +
                        "Enter invalid email (for example without @)\n" +
                        "Check that alert appeared\n" +
                        "Check that alert text is “Invalid email address.”\n" +
                        "Action 8 CHECKED!\n");
                countCheck++;
            } else {
                System.out.println("Action 7\n" +
                        "the alert text is not “Invalid email address.” its " + "“" + alertForInvalidEmailField.getText() + "”\n" +
                        "Action 8 FAILED!\n");
                countFail++;
            }
            alertForInvalidEmailField.accept();
        } catch (Exception e) {
            System.out.println("Action 8 FAILED!\n");
            countFail++;
            e.printStackTrace();
        }

        // Action 9
        try {
            WebElement searchInputField = driver.findElement(By.name("query"));
            searchInputField.sendKeys("for dummies");
            driver.findElement(By.className("search-form-submit")).click();
            driver.findElement(By.id("search-results"));
            System.out.println("Action 9:\n" +
                    "Find search input in the top of the page. Enter “for dummies” to the input field and press search icon next to the input field.\n" +
                    "Check that list of items appeared\n" +
                    "Action 9 CHECKED!\n");
        } catch (Exception e) {
            System.out.println("Action 9 FAILED!\n");
            countFail++;
            e.printStackTrace();
        }

        // Action 10
        try {
            List<WebElement> searchListEl = driver.findElement(By.id("search-results")).findElements(By.className("product-listing"));
            int randomLinkId = new Random().nextInt(searchListEl.size());
            String randomLinkText = searchListEl.get(randomLinkId).findElement(By.className("product-title")).getText();
            driver.findElement(By.linkText(randomLinkText)).click();
            driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
            if (driver.findElement(By.className("productDetail-title")).getText().contains(randomLinkText)) {
                System.out.println("Action 10:\n" +
                        "Click random item link (link with book title)\n" +
                        "Check that page with header equal to the title you clicked is displayed\n" +
                        "Action 10 CHECKED!\n");
                countCheck++;
            } else {
                System.out.println("Action 10 FAILED!\n");
                countFail++;
            }
        } catch (Exception e) {
            System.out.println("Action 10 FAILED!\n");
            countFail++;
            e.printStackTrace();
        }

        // Action 11
        try {
            WebElement home = driver.findElement(By.linkText("Home"));
            home.click();
            System.out.println("Action 11:\n" +
                    "Click “Home” link at the top navigation menu\n" +
                    "Action 11 CHECKED!\n");
            countCheck++;
        } catch (Exception e) {
            System.out.println("Action 11 FAILED!\n");
            countFail++;
            e.printStackTrace();
        }

        // Action 12
        try {
            WebElement institutions = driver.findElement(By.linkText("Institutions"));
            institutions.click();
            ArrayList<String> tabsList = new ArrayList<String>(driver.getWindowHandles());
            Thread.sleep(4000);
            driver.switchTo().window(tabsList.get(1));
            // TODO: доделать, открывается сначала http://wileyedsolutions.com/ потом идет перенаправление на
            if (driver.getCurrentUrl().contains("http://wileyedsolutions.com/")) {
                System.out.println("Action 12:\n" +
                        "Click “Institutions” icon under Resources sub-header\n" +
                        "Check http://wileyedsolutions.com/ is opened in new window (or tab)\n" +
                        "Action 12 CHECKED!\n");
                countCheck++;
            } else {
                System.out.println("Action 12:\n" +
                        "the http://wileyedsolutions.com/ is not opened in new window (or tab) it's " + driver.getCurrentUrl() + "\n" +
                        "Action 12 FAILED!\n");
                countFail++;
            }
        } catch (Exception e) {
            System.out.println("Action 12 FAILED!\n");
            countFail++;
            e.printStackTrace();
        }

        System.out.println("=============================\n" +
                "**-= ALL TESTS COMPLETE =- **\n" +
                countCheck + " actions is checked,\n" +
                countFail + " actions is failed\n" +
                "=============================");
//        driver.quit();
    }
}
