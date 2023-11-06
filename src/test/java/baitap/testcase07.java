package baitap;

import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

@Test
public class testcase07 {
    public static void testTC7() {
        WebDriver driver = driverFactory.getChromeDriver();
        String email = "max@gmail.com";
        String password = "123456";

        try {
            LoginPage login = new LoginPage(driver);
            login.goToMyAccount();
            login.Login(email, password);
            login.clickLogin();
            Thread.sleep(2000);

            WebElement orders = driver.findElement(By.linkText("MY ORDERS"));
            orders.click();

            WebElement view = driver.findElement(By.xpath("//tr[@class='first odd']//a[contains(text(),'View Order')]"));
            view.click();

            WebElement print = driver.findElement(By.xpath("//a[@class='link-print']"));
            print.click();
            Thread.sleep(2000);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
