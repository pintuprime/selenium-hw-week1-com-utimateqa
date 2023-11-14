import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
/*
Project-5 - ProjectName : com-utimateqa
BaseUrl = https://courses.ultimateqa.com/
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Click on ‘Sign In’ link
7. Print the current url
8. Enter the email to email field.
9. Enter the password to password field.
10. Click on Login Button.
11. Navigate to baseUrl.
12. Navigate forward to Homepage.
13. Navigate back to baseUrl.
14. Refresh the page.
15. Close the browser
 */

public class MultiBrowserTest {
    static String browser = "Firefox";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //1.set up multi browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //2.open Url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //3.print title of page
        String title = driver.getTitle();
        System.out.println("Title of the Page :" + title);

        //4.print current url
        System.out.println("The current url:" + driver.getCurrentUrl());

        //5.print page source
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        //6.click on sign in link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        Thread.sleep(5000);

        //7.print current url
        System.out.println("The current url:" + driver.getCurrentUrl());

        //8.enter email to emailfield
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("xyz123@yahoo.com");

        //9.enter password to password field
        WebElement passField = driver.findElement(By.id("user[password]"));
        passField.sendKeys("Password");

        //10.click on login button
        WebElement logInLink = driver.findElement(By.xpath("//button[@type='submit']"));
        logInLink.click();
        Thread.sleep(5000);

        //11.navigate to base url
        driver.navigate().to(baseUrl);

        //12.forwad to homepage
        driver.navigate().forward();
        Thread.sleep(4000);

        //13.navigate to back to baseurl
        driver.navigate().to(baseUrl);

        //14.refresh page
        driver.navigate().refresh();

        //15.close browser
        driver.close();


    }
}
