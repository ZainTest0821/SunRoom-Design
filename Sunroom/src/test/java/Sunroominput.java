import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;

public class Sunroominput {
    static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException {


        //Set capabilities

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "4bac2e52");
        caps.setCapability("deviceVersion", "12");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("skipUnlock", "false");
        //caps.setCapability("app", "C:\\Users\\Admin\\Downloads\\Sunroom Android 23.17.1.1949.apk");
        URL remoteurl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteurl, caps);

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Take user input
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the button you want to open (or 'quit' to exit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                // Exit the loop if the user enters 'quit'
                break;
            }

            // Perform actions based on user input
            if (input.equalsIgnoreCase("Demonstration")) {
                // Locate and click the demonstration button
                try {
                    WebElement demonstration = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Demonstration\"]")));
                    demonstration.click();
                } catch (WebDriverException e) {
                    WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Cancel\"]")));
                    cancel.click();
                }
            } else if (input.equalsIgnoreCase("Forgot")) {
                // Locate and click the About button
                WebElement forgot = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Forgot Code?\"]")));
                forgot.click();
            } else if (input.equalsIgnoreCase("back")) {
                driver.navigate().back();
            } else if (
                    input.equalsIgnoreCase("Start")) {
                WebElement start = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Start\"]")));
                start.click();

            } else if (input.equalsIgnoreCase("Input")) {
                WebElement invalid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
                invalid.click();
                invalid.sendKeys("TEST:1234312");
                // hide keyboard
                driver.hideKeyboard();
            } else if (input.equalsIgnoreCase("Login")) {
                WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Log In\"]")));
                login.click();
            } else if (input.equalsIgnoreCase("Cancel")) {
                WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Cancel\"]")));
                cancel.click();
            }else if (input.equalsIgnoreCase("Style")) {WebElement style = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Style\n" + "Cathedral Sunroom\"]")));
                style.click();
            } else if (input.equalsIgnoreCase("Color")) {
                WebElement colors = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Color\n" + "White Outside, Sandstone Inside\"]")));
                colors.click();
            } else if (input.equalsIgnoreCase("Width")) {
                WebElement width = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Width\n" + "14'\"]")));
                width.click();
            } else if (input.equalsIgnoreCase("Reset")) {
                WebElement reset = wait.until(ExpectedConditions.elementToBeClickable(new AppiumBy.ByAccessibilityId("Reset")));
                reset.click();
            } else if (input.equalsIgnoreCase("Yes")) {
                // Tap on 'YEs on dialog box
                WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(new AppiumBy.ByAccessibilityId("Yes")));
                yes.click();
            } else {
                System.out.println("Invalid button name entered!");
            }
            static void clickButton (n) {
                    // Locate and click the button
                    WebElement button = driver.findElement(By.id("")); // Replace with the actual element locator
            button.click();

        }
        }

    }
}




