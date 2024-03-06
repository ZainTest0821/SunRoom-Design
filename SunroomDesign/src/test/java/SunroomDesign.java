import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SunroomDesign {
    AndroidDriver driver;

    @BeforeTest
     public void Setup() throws MalformedURLException {

         //Set capabilities

         DesiredCapabilities caps = new DesiredCapabilities();

         caps.setCapability("deviceName", "4bac2e52");
         caps.setCapability("deviceVersion", "12");
         caps.setCapability("automationName", "uiautomator2");
         caps.setCapability("platformName", "Android");
         caps.setCapability("skipUnlock", "false");
         caps.setCapability("app", "C:\\Users\\Admin\\Downloads\\Sunroom Android 23.17.1.1949.apk");
         URL remoteurl = new URL("http://localhost:4723/wd/hub");

         driver = new AndroidDriver(remoteurl, caps);

     }
    @Test(priority = 1)
    // TC No 3 and 4
    public void test() throws InterruptedException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Tap on Forgot Code
        WebElement forgot = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Forgot Code?\"]")));
        forgot.click();
        Thread.sleep(1000);
        driver.navigate().back();
        // Tap on Demonstration/Cancel
        try {
            WebElement demonstration = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Demonstration\"]")));
            demonstration.click();
        } catch (WebDriverException e) {
            WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Cancel\"]")));
            cancel.click();
        }
        // Tap on Login button to click on 'Start button
        Thread.sleep(1000);
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Log In\"]")));
        login.click();
        // Tap on Start button without entering any details to check Error
        WebElement start = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Start\"]")));
        start.click();


    }

    @Test(priority = 2)
    public void Forgot() throws InterruptedException {
        // TC No 6 and 7

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Tap on Forgot Code button
        WebElement forgot = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Forgot Code?\"]")));
        forgot.click();
        Thread.sleep(2800);
        driver.navigate().back();

        // CLick on Cancel button
        WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Cancel\"]")));
        cancel.click();
        // Click on Login button again for Login dialog box
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Log In\"]")));
        login.click();
    }

    @Test(priority = 3)
    public void invalidcredentials() {
        // TC NO 8 and 9
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Enter Wrong details and Error check
        WebElement invalid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
        invalid.click();
        invalid.sendKeys("TEST:1234312");
        // hide keyboard
        driver.hideKeyboard();
        // Now click on Start button and check Error
        WebElement start = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Start\"]")));
        start.click();

    }

    @Test(priority = 4)
    public void featurelockcheck() throws InterruptedException {
        // TC No 10, 11 and 12
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // First Click on 'Cancel' button to hide the login dialog-box
        WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Cancel\"]")));
        cancel.click();

        // Click on Style feature
        WebElement style = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Style\n" + "Cathedral Sunroom\"]")));
        style.click();
        // Scroll to down to check locked features
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();

        // Scroll to Up to going back
        TouchAction action2 = new TouchAction(driver);
        action2.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();
        // Tap to back
        WebElement back = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Style\"]")));
        back.click();

        // Tap on colors
        WebElement colors = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Color\n" + "White Outside, Sandstone Inside\"]")));
        colors.click();
        // Tap on back
        WebElement back1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Color\"]")));
        back1.click();

        // Tap on Width
        WebElement width = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Width\n" + "14'\"]")));
        width.click();

        // Scroll to end
        TouchAction action3 = new TouchAction(driver);
        action3.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();

        // Scroll to up/top
        TouchAction action4 = new TouchAction(driver);
        action4.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();
        // Tap on back button
        WebElement back2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Width\"]")));
        back2.click();

        // Scroll down to test Walls features

        TouchAction action5 = new TouchAction(driver);
        action5.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();

        // Tap on Side wall
        WebElement sidewall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Side Wall\"]")));
        sidewall.click();

        // Check radio buttons
        WebElement radio1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Show Left Wall\"]/android.widget.Switch")));
        radio1.click();
        Thread.sleep(1000);
        radio1.click();

        WebElement radio2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Show Right Wall\"]/android.widget.Switch")));
        radio2.click();
        Thread.sleep(1000);
        radio2.click();

        // Scroll on top to go back
        TouchAction action6 = new TouchAction(driver);
        action6.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();
        // Tap on back button
        WebElement back3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Side Wall\"])[1]")));
        back3.click();


        // Scroll down to door
        TouchAction action7 = new TouchAction(driver);
        action7.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();

        // Tap on Door
        WebElement door = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Doors\"]")));
        door.click();
        // Scroll to up
        TouchAction action8 = new TouchAction(driver);
        action8.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();

        // Test Locked options
        WebElement Frenchdoors = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"French Doors\"]")));
        Frenchdoors.click();
        // Tap on Ok on Error dialog box
        WebElement Ok = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"OK\"]")));
        Ok.click();
        // Scroll down
        TouchAction action9 = new TouchAction(driver);
        action9.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();

        // Test Door's Seek bar
        TouchAction action10 = new TouchAction(driver);
        action10.press(PointOption.point(192, 998))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(538, 994))
                .release()
                .perform();

        // Scroll UP
        TouchAction action11 = new TouchAction(driver);
        action11.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();

        // Tap on Back button
        WebElement back4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Doors\"]")));
        back4.click();

        // Scroll down to windows
        // Scroll down
        TouchAction action12 = new TouchAction(driver);
        action12.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();


        // Tap on Windows
        WebElement window = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Windows\"]")));
        window.click();
        // Scroll up to lock feature
        TouchAction action13 = new TouchAction(driver);
        action13.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();


        // Tap on any locked feature
        WebElement fullhieght = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Full Height\"]")));
        fullhieght.click();
        // Tap on Ok button which appear on dialog box
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"OK\"]")));
        ok.click();
        // Tap on Sliding and then tap on fixed
        WebElement sliding = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Sliding\"]")));
        sliding.click();
        WebElement fixed = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Fixed\"]")));
        fixed.click();
        // SCroll down
        TouchAction action14 = new TouchAction(driver);
        action14.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();
        // Scroll UP
        TouchAction action15 = new TouchAction(driver);
        action15.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();
        // Tap on back button
        WebElement back5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Windows\"]")));
        back5.click();


        // Tap on 'Reset'
        WebElement reset = wait.until(ExpectedConditions.elementToBeClickable(new AppiumBy.ByAccessibilityId("Reset")));
        reset.click();
        // Tap on 'YEs on dialog box
        WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(new AppiumBy.ByAccessibilityId("Yes")));
        yes.click();

    }

    @Test(priority = 5)
    void loginwithvalid() {
        // TC NO 13 and 14
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Tap on login button
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Log In\"]")));
        login.click();
        WebElement valid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
        valid.click();
        valid.sendKeys("TEST:2DPMFF");
        // hide keyboard
        driver.hideKeyboard();
        // Now tap on Start button and check Error
        WebElement start = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Start\"]")));
        start.click();

        // Tap on 'Ok' button on dialog box
        WebElement OK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"OK\"]")));
        OK.click();
    }

    @Test(priority = 6)
    void featureunlockcheck() throws InterruptedException {
        // TC NO 15, 16 and 19
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Tap on Style
        WebElement style = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Style\n" + "Cathedral Sunroom\"]")));
        style.click();
        // Tap on Victorian sunroom in Style
        WebElement Victorian = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Victorian Sunroom\"]")));
        Victorian.click();
        // Tap on Cathedral Patio Cover
        WebElement Cathedral = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Cathedral Patio Cover\"]")));
        Cathedral.click();

        // Scroll down to end in 'Style'
        TouchAction a = new TouchAction(driver);
        a.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();
        // Tap on 'Edwardian in Style
        WebElement Edwardian = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Edwardian\"]")));
        Edwardian.click();

        // Scroll up
        TouchAction b = new TouchAction(driver);
        b.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();
        // Tap on Cathedral Sunroom
        WebElement cathdral = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Cathedral Sunroom\"]")));
        cathdral.click();
        // Tap on back
        WebElement back = wait.until(ExpectedConditions.elementToBeClickable(new AppiumBy.ByAccessibilityId("Style")));
        back.click();


        // Tap on Projection
        WebElement Projection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Projection\n" + "12'\"]")));
        Projection.click();
        // Tap on 8 in Projection
        WebElement Projection8 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"8'\"]")));
        Projection.click();
        // Tap on 14 in Projection
        WebElement Projection14 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"14'\"]")));
        Projection14.click();
        // Tap on 18 in Projection
        WebElement Projection18 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"18'\"]")));
        Projection18.click();
        // Tap on 20 in projection
        WebElement Projection20 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"20'\"]")));
        Projection20.click();
        // Tap on 12 in projection
        WebElement Projection12 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"12'\"]")));
        Projection12.click();

        // Tap on back button
        WebElement back1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Projection\"]")));
        back1.click();


        // Tap on Roof Material
        WebElement RoofMaterial = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Roof Material\n" + "Gray Tiles\"]")));
        RoofMaterial.click();

        //Scroll down the 3D model to see rooftop
        TouchAction rooftop = new TouchAction(driver);
        rooftop.press(PointOption.point(1478, 448))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(1483, 674))
                .release()
                .perform();

        // Tap on brown tiles
        WebElement brown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Brown Tiles\n" + "￼￼\"]")));
        brown.click();
        // Tap on Clay Roman
        WebElement Clay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Clay Roman Tiles\n" + "￼￼\"]")));
        Clay.click();
        // Scroll down to End
        TouchAction a1 = new TouchAction(driver);
        a1.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();
        // Tap on Sandstone Panel
        WebElement Sanstone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Sandstone Panel\n" + "￼￼\"]")));
        Sanstone.click();
        // Scroll UP
        TouchAction b1 = new TouchAction(driver);
        b1.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();
        // Tap on Gray tiles in Roof Material
        WebElement GrayRoofMaterial = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Gray Tiles\n" + "￼￼\"]")));
        GrayRoofMaterial.click();
        // Scroll up to reset the 3D model
        TouchAction roofdown = new TouchAction(driver);
        roofdown.press(PointOption.point(1416, 937))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(1427, 680))
                .release()
                .perform();
        // Tap on back button to go back
        WebElement back2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Roof Material\"]")));
        back2.click();


        // Tap on Pitch
        WebElement Pitch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Pitch\n" + "3/12\"]")));
        Pitch.click();
        // Tap on Pitch 2/12
        WebElement Pitch2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"2/12\"]")));
        Pitch2.click();
        // Tap on Pitch 5/12
        WebElement Pitch5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"5/12\"]")));
        Pitch2.click();
        // Tap on Pitch 7/12
        WebElement Pitch7 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"7/12\"]")));
        Pitch7.click();
        // Scroll down to end
        TouchAction a2 = new TouchAction(driver);
        a2.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();
        // Tap on Pitch 11/12
        WebElement Pitch11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"11/12\"]")));
        Pitch11.click();
        // Scroll up to top
        TouchAction b2 = new TouchAction(driver);
        b2.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();
        // Tap on 3/12 in Pitch
        WebElement Pitch3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"3/12\"]")));
        Pitch3.click();
        // Tap on back
        WebElement back3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Pitch\"]")));
        back3.click();


        // Scroll down to tap on 'Side Wall
        TouchAction a3 = new TouchAction(driver);
        a3.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();
        // Tap on Side Wall
        WebElement sidewall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Side Wall\"]")));
        sidewall.click();
        // Check radio buttons
        WebElement radio1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Show Left Wall\"]/android.widget.Switch")));
        radio1.click();
        Thread.sleep(1000);
        radio1.click();
        //
        WebElement radio2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Show Right Wall\"]/android.widget.Switch")));
        radio2.click();
        Thread.sleep(1000);
        radio2.click();

        // Tap on Wall at base
        WebElement wall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Wall at Base\"]")));
        wall.click();
        // Tap on none
        WebElement none = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"None\"]")));
        none.click();
        // Tap on Panel at base
        WebElement panel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Panel at Base\"]")));
        panel.click();
        // Scroll to top to go on back button'
        TouchAction b3 = new TouchAction(driver);
        b3.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();
        //Tap on back button
        WebElement back4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Side Wall\"])[1]")));
        back4.click();


        // Scroll down to 'Windows'
        TouchAction a4 = new TouchAction(driver);
        a4.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();
        // Tap on Windows
        WebElement window = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Windows\"]")));
        window.click();
        // Scroll to up
        TouchAction b4 = new TouchAction(driver);
        b4.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();
        // Tap on Full Height
        WebElement height = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Full Height\"]")));
        height.click();
        // Tap on Sash
        WebElement Sash = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Sash\"]")));
        Sash.click();
        // Tap on Top Opener
        WebElement opener = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Top Opener\"]")));
        opener.click();
        //Tap on Sliding
        WebElement sliding = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Sliding\"]")));
        sliding.click();

        // Scroll to down
        TouchAction a5 = new TouchAction(driver);
        a5.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();

        // Window Open Amount
        TouchAction windowopen = new TouchAction(driver);
        windowopen.press(PointOption.point(402, 706))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(98, 706))
                .release()
                .perform();

        // Move left the 3D model to check the windows
        TouchAction model3d = new TouchAction(driver);
        model3d.press(PointOption.point(1411, 696))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(1138, 710))
                .release()
                .perform();

        Thread.sleep(1500);
        // Downgrade the Window open amount
        TouchAction windowopen1 = new TouchAction(driver);
        windowopen1.press(PointOption.point(187, 706))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(374, 706))
                .release()
                .perform();

        Thread.sleep(1500);

        // Move right the 3D model to check the windows
        TouchAction model3d1 = new TouchAction(driver);
        model3d1.press(PointOption.point(1448, 752))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(1736, 742))
                .release()
                .perform();
        // Reset the position of 3D model
        TouchAction model3d2 = new TouchAction(driver);
        model3d2.press(PointOption.point(1550, 721))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(1231, 731))
                .release()
                .perform();
        // Tap on Windows Gride
        WebElement grid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Window Grids\"]/android.widget.Switch")));
        grid.click();
        Thread.sleep(700);
        grid.click();

        // Scroll to top
        TouchAction b5 = new TouchAction(driver);
        b5.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();
        // Tap on back
        WebElement back5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Windows\"]")));
        back5.click();


        // Scroll down to Door
        TouchAction a6 = new TouchAction(driver);
        a6.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();
        // Tap on Door
        WebElement door = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Doors\"]")));
        door.click();
        // Scroll up
        TouchAction b6 = new TouchAction(driver);
        b6.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();
        // Tap on Sliding door
        WebElement slidingdoor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Sliding Doors\"]")));
        slidingdoor.click();
        // Tap on Signle door inward
        WebElement singledoor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Single Door Inward\"]")));
        slidingdoor.click();
        // Tap on Bifold door
        WebElement bifold = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Single Door Inward\"]")));
        bifold.click();

        // Scroll down to stacking
        TouchAction stacking = new TouchAction(driver);
        stacking.press(PointOption.point(391, 932))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(397, 386))
                .release()
                .perform();
        // Tap on Stacking Doors
        WebElement stacking1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Stacking Doors\"]")));
        stacking1.click();

        // Scroll down to end
        TouchAction a7 = new TouchAction(driver);
        a7.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();
        // Tap on Left wall Radio button
        WebElement leftwall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Left Wall\"]/android.widget.Switch")));
        leftwall.click();
        // Scroll left to check door
        TouchAction model3ddoor = new TouchAction(driver);
        model3ddoor.press(PointOption.point(1411, 696))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(1138, 710))
                .release()
                .perform();
        // Tap on Right wall radio button
        WebElement rightwall = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Right Wall\"]/android.widget.Switch")));
        rightwall.click();

        // Move right to check door
        TouchAction model3ddoor1 = new TouchAction(driver);
        model3ddoor1.press(PointOption.point(1448, 752))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(1736, 742))
                .release()
                .perform();
        Thread.sleep(1500);
        // Reset the position of 3d Model
        TouchAction resetposition = new TouchAction(driver);
        resetposition.press(PointOption.point(1550, 721))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(1231, 731))
                .release()
                .perform();
        // Scroll to top to go back
        TouchAction b7 = new TouchAction(driver);
        b7.press(PointOption.point(384, 134))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(341, 1061))
                .release()
                .perform();
        // Tap on back button
        WebElement back6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Doors\"]")));
        back6.click();


        // Scroll down to 'Gable Type
        TouchAction a8 = new TouchAction(driver);
        a8.press(PointOption.point(355, 1066))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(346, 274))
                .release()
                .perform();
        //Tap on Gable
        WebElement gable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Gable Type\n" + "Glass\"]")));
        gable.click();
        //Tap on Glass in Gable
        WebElement Glass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Glass\"]")));
        Glass.click();
        // Tap on Solid
        WebElement Solid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Solid\"]")));
        Solid.click();
        // Tap on Queen Post
        WebElement queen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Queen Post\"]")));
        queen.click();
        // Tap on Sunbrust
        WebElement sunbrust = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Sunburst\"]")));
        sunbrust.click();
        // Tap on Raked Frames
        WebElement Raked = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Raked Frames\"]")));
        Raked.click();

        // Tap on back
        WebElement back7 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Gable Type\"]")));
        back7.click();

        // Tap on 'Reset'
        WebElement reset = wait.until(ExpectedConditions.elementToBeClickable(new AppiumBy.ByAccessibilityId("Reset")));
        reset.click();
        // Tap on 'YEs on dialog box
        WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(new AppiumBy.ByAccessibilityId("Yes")));
        yes.click();

    }

    @Test(priority = 7)
    void About() throws InterruptedException {
        // TC NO 21 to End
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Tap on 'Info'
        WebElement Info = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Info\"]")));
        Info.click();
        // Tap on About from 'Info's' option
        WebElement About = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"About\"]")));
        About.click();


        // Get ap version in output
        WebElement appversion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"App Version 23.17.1.1949\"]")));
        appversion.getText();
        System.out.println("App Version:" + appversion);
        // Get Config Version
        WebElement config = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Config Version SRDP 23.17.1.3\"]")));
        config.getText();
        System.out.println("Config Version:" + config);
        //Get Licensed User
        WebElement licensed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Licensed User: Peter Wilson_SunroomDesignerPlusTest\"]")));
        licensed.getText();
        System.out.println("User's Licensed:" + licensed);
        // Get licensed Company
        WebElement licensed1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Licensed Company: Peter Wilson_SunroomDesignerPlusTest\"]")));
        licensed1.getText();
        System.out.println("Company's licensed:" + licensed1);

        // Scroll to end
        TouchAction down = new TouchAction(driver);
        down.press(PointOption.point(1268, 773))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(1243, 182))
                .release()
                .perform();

        // Tap on link
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"https://homeapphub.com/sunroom/\"]")));
        link.click();
        Thread.sleep(1500);
        driver.navigate().back();
        // Tap on 2nd link
        WebElement link2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Legal information\"]")));
        link2.click();
        Thread.sleep(1500);
        driver.navigate().back();

        // Get App copyright
        WebElement copyright = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"App Copyright RPS Limited 2023\"]")));
        copyright.getText();
        System.out.println("App Copyright Details:" + copyright);

        // Tap on close button
        WebElement close = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Close\"]")));
        close.click();


    }

    @AfterTest
    public void teardown() {
        if (null != driver) {
            System.out.println("Error occur");
            driver.quit();
        }

    }


}
