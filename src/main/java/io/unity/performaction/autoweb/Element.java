package io.unity.performaction.autoweb;


import com.google.common.net.MediaType;
import io.appium.java_client.AppiumBy;
import io.unity.framework.exception.locator_validation_exception;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.NetworkInterceptor;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.http.Route;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static org.openqa.selenium.remote.http.Contents.utf8String;


public class Element {

    WebDriver driver;
    testng_logs logs = new testng_logs();


    public Element(WebDriver dri) {
        this.driver = dri;
    }


    private WebElement get_element_from_value(String locator_type, String locator_value) {
        WebElement element = null;
        switch (locator_type) {
            case "xpath":
                element = driver.findElement(By.xpath(locator_value));
                break;
            case "id":
                element = driver.findElement(By.id(locator_value));
                break;
            case "css_selector":
                element = driver.findElement(By.cssSelector(locator_value));
                break;
            case "class_name":
                element = driver.findElement(By.className(locator_value));
                break;
            case "name":
                element = driver.findElement(By.name(locator_value));
                break;
            case "link_text":
                element = driver.findElement(By.linkText(locator_value));
                break;
            case "partial_link_text":
                element = driver.findElement(By.partialLinkText(locator_value));
                break;
            case "tag":
                element = driver.findElement(By.tagName(locator_value));
                break;
            case "accessibility-id":
                element = driver.findElement(new AppiumBy.ByAccessibilityId(locator_value));
                break;
            default:
                logs.test_step("Incorrect Locator Type");
        }
        return element;
    }


    public WebElement find(String locator_value) {

        WebElement element = null;
        locator_reader reader = new locator_reader();

        Map<String, String> locator_details = reader.get_locator_value(locator_value);
        element = get_element_from_value(locator_details.get("locator_type"), locator_details.get("locator_value"));

        return element;
    }

    public WebElement find_element_by_xpath(String locator_value) {
        WebElement element = null;
        element = driver.findElement(By.xpath(locator_value));
        return element;
    }

    public WebElement find_element_using_dynamic_xpath(String locator_value, Map<String, String> dynamic_value) throws locator_validation_exception {
        WebElement element = null;
        locator_reader reader = new locator_reader();


        Map<String, String> locator_details = reader.get_locator_value(locator_value);


        String final_xpath = "";
        if (locator_details.get("locator_type").equalsIgnoreCase("dyn-xpath")) {
            String current_xpath = locator_details.get("locator_value");
            final_xpath = current_xpath;
            if (current_xpath.contains("${")) {

                for (Map.Entry<String, String> entry : dynamic_value.entrySet()) {

                    System.out.println("Key = " + entry.getKey() +
                            ", Value = " + entry.getValue());

                    final_xpath = final_xpath.replace("${" + entry.getKey() + "}", entry.getValue());
                }

            } else {
                throw new locator_validation_exception("No Dynamic Value Found in locator");
            }


        } else {
            throw new locator_validation_exception("locator type is not a dyn-xpath, This method only use for the Dynamic Xpath ");
        }

        return driver.findElement(By.xpath(final_xpath));
    }

    public List<WebElement> find_multiple_elements(String locator_value) {

        List<WebElement> elements = null;

        locator_reader reader = new locator_reader();

        Map<String, String> locator_details = reader.get_locator_value(locator_value);




        switch (locator_details.get("locator_type")) {
            case "xpath":
                elements = driver.findElements(By.xpath(locator_details.get("locator_value")));
                break;
            case "id":
                elements = driver.findElements(By.id(locator_details.get("locator_value")));
                break;
            case "css_selector":
                elements = driver.findElements(By.cssSelector(locator_details.get("locator_value")));
                break;
            case "class_name":
                elements = driver.findElements(By.className(locator_details.get("locator_value")));
                break;
            case "name":
                elements = driver.findElements(By.name(locator_details.get("locator_value")));
                break;
            case "link_text":
                elements = driver.findElements(By.linkText(locator_details.get("locator_value")));
                break;
            case "partial_link_text":
                elements = driver.findElements(By.partialLinkText(locator_details.get("locator_value")));
                break;
            case "tag":
                elements = driver.findElements(By.tagName(locator_details.get("locator_value")));
                break;
            default:
                logs.test_step("Incorrect Locator Type");
        }

        return elements;
    }


    public List<WebElement> find_multiple_element_from_element(String main_element, String element_to_find) {
        WebElement main = find(main_element);

        List<WebElement> elements = null;

        locator_reader reader = new locator_reader();

        Map<String, String> locator_details = reader.get_locator_value(element_to_find);


        switch (locator_details.get("locator_type")) {
            case "xpath":
                elements = main.findElements(By.xpath(locator_details.get("locator_value")));
                break;
            case "id":
                elements = main.findElements(By.id(locator_details.get("locator_value")));
                break;
            case "css_selector":
                elements = main.findElements(By.cssSelector(locator_details.get("locator_value")));
                break;
            case "class_name":
                elements = main.findElements(By.className(locator_details.get("locator_value")));
                break;
            case "name":
                elements = main.findElements(By.name(locator_details.get("locator_value")));
                break;
            case "link_text":
                elements = main.findElements(By.linkText(locator_details.get("locator_value")));
                break;
            case "partial_link_text":
                elements = main.findElements(By.partialLinkText(locator_details.get("locator_value")));
                break;
            case "tag":
                elements = main.findElements(By.tagName(locator_details.get("locator_value")));
                break;
            default:
                logs.test_step("Incorrect Locator Type");
        }


        return elements;
    }


    public WebElement find_element_from_element(String main_element, String element_to_find) {
        WebElement main = find(main_element);

        WebElement element = null;
        String[] locator_to_find = element_to_find.split(":");

        switch (locator_to_find[0]) {
            case "xpath":
                element = main.findElement(By.xpath(locator_to_find[1]));
                break;
            case "id":
                element = main.findElement(By.id(locator_to_find[1]));
                break;
            case "css_selector":
                element = main.findElement(By.cssSelector(locator_to_find[1]));
                break;
            case "class_name":
                element = main.findElement(By.className(locator_to_find[1]));
                break;
            case "name":
                element = main.findElement(By.name(locator_to_find[1]));
                break;
            case "link_text":
                element = main.findElement(By.linkText(locator_to_find[1]));
                break;
            case "partial_link_text":
                element = main.findElement(By.partialLinkText(locator_to_find[1]));
                break;
            case "tag":
                element = main.findElement(By.tagName(locator_to_find[1]));
                break;
            default:
                logs.test_step("Incorrect Locator Type");
        }

        return element;
    }

    public WebElement get_active_element() {

        return driver.switchTo().activeElement();
    }

    public String get_element_tag(String locator_value) {
        return find(locator_value).getTagName();
    }

    public String get_css_value(String locator_value, String css) {

        return find(locator_value).getCssValue(css);
    }

    public String get_element_text(String locator_value) {
        return find(locator_value).getText();
    }

    public void enter_text(String locator_value, String text_to_enter) {
        logs.test_step("Enter text " + text_to_enter + " at locator " + locator_value);
        find(locator_value).sendKeys(text_to_enter);
    }

    public void clear_text_field(String locator_value) {
        logs.test_step("clear value from " + locator_value + " text fields");
        find(locator_value).clear();
    }

    public void clear_and_enter_in_text_field(String locator_value, String text_to_enter) {
        logs.test_step("clear value from " + locator_value + " text fields and enter text " + text_to_enter);
        find(locator_value).clear();
        find(locator_value).sendKeys(text_to_enter);
    }

    public void click(String locator_value) {
        logs.test_step("Click on " + locator_value);
        find(locator_value).click();
    }

    /**
     * @param element_name
     * @param element_text_for_click
     * @apiNote Click on the First element from the list
     */
    public void click_on_element_with_text_from_list(String element_name, String element_text_for_click) {
        logs.test_step("Click on " + element_text_for_click + " from list ");
        List<WebElement> elements_list = find_multiple_elements(element_name);
        Boolean bool = false;

        for (WebElement element : elements_list) {
            if (element.getText().contains(element_text_for_click)) {
                click(element_name);
                break;
            }
        }

    }

    public void click_using_js(WebElement element) throws Exception {
        try {
            logs.test_step("Click on " + element);
            if (element.isEnabled() && element.isDisplayed()) {
                logs.test_step("Clicking on element with using java script click");

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else {
                logs.test_step("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            logs.test_step("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            logs.test_step("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            logs.test_step("Unable to click on element " + e.getStackTrace());
        }
    }

    public String get_attribute_value(String locator_value, String attribute_name) {
        return find(locator_value).getAttribute(attribute_name);
    }


    public void take_element_screen_shot(WebElement element, String image_name) {

        File scrFile = element.getScreenshotAs(OutputType.FILE);
        try {
            File screenshot_file = new File("./" + image_name + ".png");
            FileUtils.copyFile(scrFile, screenshot_file);
            logs.test_step("Screenshot saved at  <img href=" + screenshot_file.getAbsolutePath() + ">");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void network_interception_Method(WebDriver driver) {
         /* 1. If you want to capture network events coming into the browser
            2. and you want to manipulate them you are able to do it with the following examples.*/

        try (NetworkInterceptor interceptor = new NetworkInterceptor(
                driver,
                Route.matching(req -> true)
                        .to(() -> req -> new HttpResponse()
                                .setStatus(200)
                                .addHeader("Content-Type", MediaType.HTML_UTF_8.toString())
                                .setStatus(200)
                                .setContent(utf8String("Creamy, delicious cheese!"))));) {
            logs.test_step("INFO : Network Interceptor is executed..");
        } catch (Exception e) {
            logs.test_step("INFO : " + e.getStackTrace());
        }

    }

    public void jsException_method(ChromeDriver driver, String locator_value) {
        //Usage Of This method :
        //Listen to the JS Exceptions and register callbacks to process the exception details.

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        ((ChromeDriver) driver).getDevTools().createSession();

        List<JavascriptException> jsExceptionsList = new ArrayList<>();
        Consumer<JavascriptException> addEntry = jsExceptionsList::add;
        devTools.getDomains().events().addJavascriptExceptionListener(addEntry);

        WebElement link2click = find(locator_value);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                link2click, "onclick", "throw new Error('Hello, world!')");
        link2click.click();

        for (JavascriptException jsException : jsExceptionsList) {
            logs.test_step("JS exception message: " + jsException.getMessage());
            logs.test_step("JS exception system information: " + jsException.getSystemInformation());
            logs.test_step("JS exception Get cause : " + jsException.getCause());
            logs.test_step("JS exception get Build Information: " + jsException.getBuildInformation());
            logs.test_step("JS exception Get full stack trace : " + jsException.fillInStackTrace());
            logs.test_step("JS exception get raw Message : " + jsException.getRawMessage());

            jsException.printStackTrace();
        }
    }

    public void console_Log_method(ChromeDriver driver) {
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.getCdpSession();
        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(),
                logEntry -> {
                    logs.test_step("INFO : log      : " + logEntry.getText());
                    logs.test_step("INFO : level    : " + logEntry.getLevel());
                    logs.test_step("INFO : Time     : " + logEntry.getTimestamp());
                    logs.test_step("INFO : URL      : " + logEntry.getUrl());
                    logs.test_step("INFO : WorkerID : " + logEntry.getWorkerId());

                });

    }

    public void select_single_option_from_dropdown(String locator_value, String Value) {
        Select drp = new Select(find(locator_value));
        List<WebElement> options = drp.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(Value)) {
                option.click();
                break;
            }
            logs.test_step("INFO : " + Value + " is selected.");
        }
    }

    public void select_all_options_options_from_dropDown(String locator_value) {
        Select drp = new Select(find(locator_value));
        boolean multiple_Selected_dropDown = drp.isMultiple();
        List<WebElement> options = drp.getOptions();
        if (multiple_Selected_dropDown == true) {
            for (WebElement option : options) {
                option.click();
            }
            logs.test_step("INFO : All options are Selected..");
        } else {
            logs.test_step("INFO : This Dropdown is not a multiSelected DropDown.");
        }
    }

    public void select_options_from_dropdown_by_value(String locator_value, String value) {
        Select drp = new Select(find(locator_value));
        drp.selectByValue(value);
        logs.test_step("INFO : Select " + value + " From Dropdown");

    }

    public void select_options_from_dropdown_by_index(String locator_value, int index) {
        Select drp = new Select(find(locator_value));
        drp.selectByIndex(index);
        logs.test_step("INFO : Select " + index + " Index From Dropdown");

    }

    public void select_options_from_dropdown_by_visibleText(String locator_value, String visibleText) {
        Select drp = new Select(find(locator_value));
        drp.selectByVisibleText(visibleText);
        logs.test_step("INFO : Select " + visibleText + " From Dropdown");

    }

    public void deSelect_allOptions_from_dropDown(String locator_value) {
        Select drp = new Select(find(locator_value));
        boolean multiple_Selected_dropDown = drp.isMultiple();
        if (multiple_Selected_dropDown == true) {
            drp.deselectAll();
            logs.test_step("INFO : All options are DeSelected..");
        } else {
            logs.test_step("INFO : This Dropdown is not a multiSelected DropDown.");
        }

    }

    public void deSelect_options_from_dropDown_using_index(String locator_value, int index) {
        Select drp = new Select(find(locator_value));
        drp.deselectByIndex(index);
        logs.test_step("INFO : De-Select " + index + " From Dropdown");
    }

    public void deSelect_options_from_dropDown_using_value(String locator_value, String value) {
        Select drp = new Select(find(locator_value));
        drp.deselectByValue(value);
        logs.test_step("INFO : De-Select " + value + " From Dropdown");
    }

    public void deSelect_options_from_dropDown_using_visible_text(String locator_value, String text) {
        Select drp = new Select(find(locator_value));
        drp.deselectByVisibleText(text);
        logs.test_step("INFO : De-Select " + text + " From Dropdown");
    }

    public void get_all_selected_options_from_dropDown(String locator_value) {
        Select drp = new Select(find(locator_value));
        List<WebElement> AllOptions = drp.getAllSelectedOptions();
        for (WebElement option : AllOptions) {
            logs.test_step("INFO : Selected Options are : " + option.getText());
        }
    }

    public void perform_scroll_to_element(String locator_value) {

        new Actions(driver)
                .scrollToElement(find(locator_value))
                .perform();
    }

    public void perform_horizontal_scroll_to_element(String locator_value, int scroll_amount) {

        int deltaY = find(locator_value).getRect().y;
        new Actions(driver)
                .scrollByAmount(scroll_amount, deltaY)
                .perform();
    }

    public void perform_scroll_by_amount(int x, int y) {

        new Actions(driver)
                .scrollByAmount(x, y)
                .perform();
    }

    public void perform_scroll_from_element_by_amount(String locator_value, int x, int y) {

        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(find(locator_value));
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, x, y)
                .perform();
    }


}
