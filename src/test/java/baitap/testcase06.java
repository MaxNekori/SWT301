package baitap;

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import POM.RegisterPage;
import org.testng.asserts.Assertion;

import java.io.File;

@Test
public class testcase06 {
    public static void testTC6() {
        WebDriver driver = driverFactory.getChromeDriver();
        String email = "max@gmail.com";
        String password = "123456";
        String country = "United States";
        String state = "Florida";
        String zip = "2000";
        String firstname = "max";
        String lastname = "maths";
        String address = "hcm123";
        String city = "HCM";
        String telephone = "0123456789";

        try{
            LoginPage login = new LoginPage(driver);
            login.goToMyAccount();
            login.Login(email, password);
            login.clickLogin();
            Thread.sleep(2000);

            WebElement wishlist = driver.findElement(By.linkText("MY WISHLIST"));
            wishlist.click();

            WebElement addToCart = driver.findElement(By.xpath("//button[@type='button']//span//span[contains(text(),'Add to Cart')]"));
            addToCart.click();

            CartPage cart = new CartPage(driver);
            cart.enterCountry(country);
            cart.enterStateProvince(state);
            cart.enterZip(zip);
            cart.clickEstimate();
            cart.verifyShippingCost();
            cart.clickUpdateTotal();
            cart.verifyTotal();
            cart.clickCheckout();
            Thread.sleep(2000);

            CheckOutPage checkout = new CheckOutPage(driver);
            checkout.newBillingAddress();
            checkout.fillForm1(firstname, lastname, address, city);
            checkout.fillForm2(state, zip, country, telephone);
            checkout.chooseDifferentAddress();
            checkout.clickBillingContinue();
            Thread.sleep(2000);

            checkout.newShippingAddress();
            checkout.fillForm3(firstname, lastname, address, city);
            checkout.fillForm4(state, zip, country, telephone);
            checkout.clickShippingContinue();
            Thread.sleep(2000);

            checkout.clickShippingMethod();
            Thread.sleep(2000);
            checkout.selectCheck();;
            checkout.clickPaymentContinue();
            Thread.sleep(2000);
            checkout.clickPlaceOrder();
            Thread.sleep(2000);

            checkout.verifyOrder();
            Thread.sleep(2000);

            checkout.getOrderId();

            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String png = ("D:\\Kì 5\\SWT301 - NET\\SeleniumWebdriver\\selenium-webdriver-java\\src\\test\\resources\\Screenshot\\testcase6.png");
            FileUtils.copyFile(srcFile, new File(png));


        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}
