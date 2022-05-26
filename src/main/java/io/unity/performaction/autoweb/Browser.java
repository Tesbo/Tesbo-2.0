package io.unity.performaction.autoweb;

import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.testng_logs;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        logs.test_step("getting current page title : " +current_page_title);
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
            FileUtils.copyFile(scrFile,screenshot_file);

            logs.test_step("Screenshot saved at  <img href="+screenshot_file.getAbsolutePath()+">" );
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
            logs.test_step("Screenshot saved at  <img href="+screenshot_file.getAbsolutePath()+">" );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}

