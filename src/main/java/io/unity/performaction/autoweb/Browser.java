package io.unity.performaction.autoweb;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.javalin.http.SinglePageHandler;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v101.emulation.Emulation;
import org.openqa.selenium.devtools.v101.emulation.model.DisplayFeature;
import org.openqa.selenium.devtools.v101.log.Log;
import org.openqa.selenium.devtools.v101.performance.Performance;
import org.openqa.selenium.devtools.v101.performance.model.Metric;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.virtualauthenticator.Credential;
import org.openqa.selenium.virtualauthenticator.HasVirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class Browser {
    WebDriver driver;
    Element element;
    testng_logs logs = new testng_logs();

    public Browser(WebDriver dri) {
        this.driver = dri;
        element = new Element(driver);

    }


    public void open_url(String url) {

        driver.get(url);
    }


    public String get_current_url() {
        String current_url = driver.getCurrentUrl();
        logs.test_step("getting current url : " + current_url);
        return current_url;
    }

    public String get_page_source() {
        String current_page_source = driver.getPageSource();
        logs.test_step("getting current page source : ");
        logs.test_step("==========================================================");
        logs.test_step(current_page_source);
        logs.test_step("==========================================================");

        return driver.getPageSource();
    }

    public String get_title() {
        String current_page_title = driver.getTitle();
        logs.test_step("getting current page title : " + current_page_title);
        return current_page_title;
    }

    public void navigate_to_back() {
        logs.test_step("Navigate to previous page");
        driver.navigate().back();
    }

    public void navigate_to_forward() {
        logs.test_step("Navigate to Next page");

        driver.navigate().forward();
    }

    public void refresh_page() {
        logs.test_step("Refresh the Page");
        driver.navigate().refresh();
    }

    public void close_browser() {
        logs.test_step("Close browser");
        driver.quit();
    }

    public void take_page_screenshot(String image_name) {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            create_screenshot_dir();
            File screenshot_file = new File("./screenshot/" + image_name + ".png");
            FileUtils.copyFile(scrFile, screenshot_file);

            logs.test_step("Screenshot saved at  <img href=" + screenshot_file.getAbsolutePath() + ">");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void create_screenshot_dir() throws IOException {
        Path screen_shot_path = Paths.get("./" + "screenshot");
        if (!Files.isDirectory(screen_shot_path)) {
            Files.createTempDirectory(screen_shot_path.toAbsolutePath().toString());
        }


    }


    public void take_page_screenshot(String folder_path, String image_name) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File screenshot_file = new File(folder_path + "/" + image_name + ".png");
            FileUtils.copyFile(scrFile, screenshot_file);
            logs.test_step("Screenshot saved at  <img href=" + screenshot_file.getAbsolutePath() + ">");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addCookie(String cookieName, String cookieValue) {
        var cookie = new Cookie(cookieName, cookieValue);
        driver.manage().addCookie(cookie);
    }

    public Cookie get_named_cookies(String cookieName) {
        Cookie cookie1 = driver.manage().getCookieNamed(cookieName);
        return cookie1;
    }

    public Set<Cookie> getAllCookies() {
        return driver.manage().getCookies();
    }

    public void deleteCookie(String cookieName) {
        Cookie cookie = driver.manage().getCookieNamed(cookieName);
        driver.manage().deleteCookie(cookie);
    }

    public void deleteAllCookie() {
        driver.manage().deleteAllCookies();
    }

    public void cookies_strict(String cookieName, String cookieValue) {
        Cookie cookie = new Cookie.Builder(cookieName, cookieValue).sameSite("Strict").build();
        driver.manage().addCookie(cookie);
    }

    public void cookies_lax(String cookieName, String cookieValue) {
        Cookie cookie1 = new Cookie.Builder(cookieName, cookieValue).sameSite("Lax").build();
        driver.manage().addCookie(cookie1);
    }

    public void DragandDrop(String source, String target) {
        Element element1 = new Element(driver);
        WebElement from = element1.find(source);
        WebElement to = element1.find(target);

        new Actions(driver)
                .dragAndDrop(from, to)
                .perform();
    }

    public void drag_and_drop_byOffset(String source, String target) {
        Element element1 = new Element(driver);
        WebElement draggable = element1.find(source);
        Rectangle start = draggable.getRect();
        Rectangle finish = element1.find(target).getRect();
        new Actions(driver)
                .dragAndDropBy(draggable, finish.getX() - start.getX(),
                        finish.getY() - start.getY()).perform();
    }

    public void emulate_geo_location(double latitude, double longitude, double accuracy) {

        ChromeDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().getInstance();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride
                (Optional.of(latitude),
                        Optional.of(longitude),
                        Optional.of(accuracy)));
    }

    public void emulate_geo_location_with_remote_webDriver(double latitude, double longitude, double accuracy) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("<grid-url>"), chromeOptions);
        driver = new Augmenter().augment(driver);

        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

        devTools.send(Emulation.setGeolocationOverride
                (Optional.of(latitude),
                        Optional.of(longitude),
                        Optional.of(accuracy)));
    }

    public void over_ride_deviceMode(Integer width, Integer height, Number deviceScaleFactor, Boolean mobile) {

        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Emulation.setDeviceMetricsOverride
                (width,
                        height,
                        deviceScaleFactor,
                        mobile,
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()));
//        driver.get("https://selenium.dev/");
//        driver.quit();
    }

    public void getPerformanceMetrics() {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        List<Metric> metricList = devTools.send(Performance.getMetrics());
//        System.out.println("metrics is :" + metricList);

        for (Metric m : metricList) {
            System.out.println(m.getName() + " = " + m.getValue());
        }
    }

    public void create_authenticator() {
        // Create virtual authenticator options
        VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
                .setProtocol(VirtualAuthenticatorOptions.Protocol.U2F)
                .setHasResidentKey(false);

        // Register a virtual authenticator
        VirtualAuthenticator authenticator =
                ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);

        List<Credential> credentialList = authenticator.getCredentials();
    }

    public void remove_authenticator() {

        // Create virtual authenticator options
        VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions();
        VirtualAuthenticator authenticator =
                ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);

        ((HasVirtualAuthenticator) driver).removeVirtualAuthenticator(authenticator);
    }

    public void set_user_verified() {
        VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
                .setIsUserVerified(true);
    }

    public void capture_console_logs(WebDriver driver){

        DevTools devTools = ((ChromeDriver)driver).getDevTools();;

        devTools.createSession();

        devTools.send(org.openqa.selenium.devtools.v85.runtime.Runtime.enable());
        devTools.send(Log.enable());

        devTools.addListener(Log.entryAdded(),
                logEntry -> {
                    System.out.println("log: " + logEntry.getText());
                    System.out.println("level: " + logEntry.getLevel());
                });
    }
}

