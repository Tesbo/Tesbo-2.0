package io.unity.performaction.autoweb;


import io.unity.framework.exception.list_size_not_matching_exception;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Verify {


    WebDriver driver;
    Element element;
    testng_logs logs = new testng_logs();

    public Verify(WebDriver dri) {
        this.driver = dri;
        element = new Element(driver);

    }

    public void element_is_present(String element_name) {
        boolean bool = false;
        logs.test_step("verify " + element_name + " is displayed");
        try {
            if (element.find(element_name).isDisplayed()) {
                bool = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(bool).isTrue();
        logs.test_result(bool);

    }

    public boolean check_element_is_present(String element_name) {
        boolean bool = false;

        try {
            if (element.find(element_name).isDisplayed()) {
                bool = true;

            }
        } catch (Exception e) {

        }

        return bool;

    }

    public void element_is_enable(String element_name) {
        logs.test_step("verify " + element_name + " is enable");
        boolean bool = false;
        try {
            if (element.find(element_name).isEnabled()) {
                bool = true;

            }
        } catch (Exception e) {

        }
        assertThat(bool).isTrue();
        logs.test_result(bool);
    }

    public void element_is_selected(String element_name) {
        logs.test_step("verify " + element_name + " is selected");
        boolean bool = false;
        try {
            if (element.find(element_name).isSelected()) {
                bool = true;

            }
        } catch (Exception e) {

        }
        assertThat(bool).isTrue();
        logs.test_result(bool);

    }

    public void current_title_is_equal_to(String title) {
        logs.test_step("verify current page title is " + title);
        assertThat(driver.getTitle()).isEqualTo(title);
        logs.test_result(true);
    }

    public void element_text_is_equal_to(String element_name, String text_to_verify) {
        logs.test_step("verify element " + element_name + " text is equal " + text_to_verify);
        assertThat(element.find(element_name).getText()).isEqualTo(text_to_verify);
        logs.test_result(true);
    }

    /**
     *
     * @param element_name name of the element from json file
     * @param attribute_name attribute that you wanted to compare
     * @param expected_attribute_value attribute value that you wanted to compare
     */
    public void element_attribute_is_equal_to(String element_name, String attribute_name, String expected_attribute_value) {
        logs.test_step("verify element " + element_name + " attribute " + attribute_name + " text is equal " + expected_attribute_value);
        assertThat(element.find(element_name).getAttribute(attribute_name)).isEqualTo(expected_attribute_value);
        logs.test_result(true);
    }

    public void element_text_is_available_in_list(String element_name, String text_to_verify) {
        logs.test_step("verify text " + text_to_verify + " is available into " + element_name);
        List<WebElement> elements_list = element.find_multiple_elements(element_name);
        Boolean bool = false;

        for (WebElement element : elements_list) {

            if (element.getText().contains(text_to_verify)) {
                bool = true;
            }
        }
        assertThat(bool).isTrue();
        logs.test_result(true);
    }


    public ArrayList<String> convert_web_element_to_string_list(List<WebElement> elements_list) {

        ArrayList<String> actual_list = new ArrayList<>();
        for (WebElement element_list_member : elements_list) {
            actual_list.add(element_list_member.getText());
        }
        return actual_list;
    }

    public void element_text_is_in_alphabetical_order(String element_name, ArrayList<String> list_to_verify) throws list_size_not_matching_exception {
        List<WebElement> elements_list = element.find_multiple_elements(element_name);
        ArrayList<String> actual_list = convert_web_element_to_string_list(elements_list);

        Boolean bool = false;

        Collections.sort(actual_list);

        if (actual_list.size() == list_to_verify.size()) {
            for (int i = 0; i < actual_list.size(); i++) {

                if (actual_list.get(i).equalsIgnoreCase(list_to_verify.get(i))) {
                    bool = true;
                } else {
                    bool = false;
                    break;
                }
            }
        } else {
            bool = false;
            throw new list_size_not_matching_exception("Element List on page is not matching with the Given List");
        }
        assertThat(bool).isTrue();

    }


}
