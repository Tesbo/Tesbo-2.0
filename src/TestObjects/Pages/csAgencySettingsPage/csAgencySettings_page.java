package TestObjects.Pages.csAgencySettingsPage;

import Framework.java.io.unity.performaction.autoweb.Element;
import Framework.java.io.unity.performaction.autoweb.Verify;
import Framework.java.io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class csAgencySettings_page {
    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;
    HashMap<String,String > map = new HashMap<>();
    JavascriptExecutor jsExecutor = null;
    String postFixToIntegrationTextBoxLocators = "/following-sibling::div/descendant::span[contains(@class, 'p-error')]";

    public csAgencySettings_page(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
    }

    public void verify_csuser_on_agency_settings_page(String agency){
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(60));
        wt.until(ExpectedConditions.jsReturnsValue("return document.title==='Settings'"));
        verify.element_text_is_equal_to("top_agency_nav_button", agency);
    }

    public void edit_agency_details(String name){
        element.click("cs_agency_edit_button");
        wait.wait_until_element_is_clickable("new_agency_name");
        wait.wait_for_second(2);
        element.perform_scroll_to_element("new_agency_name");
        element.clear_and_enter_in_text_field("new_agency_name", name);
    }

    public void click_on_update_to_save_updated_details(){
        element.click("new_agency_save");
        wait.wait_for_second(2);
        verify.element_text_is_equal_to("cs_agency_update_message_pop_up", "Organization modified successfully");
    }

    public void click_and_navigate_to_automation_rules_tab(){
        verify.element_is_present("cs_agency_automation_rules_link");
        element.click("cs_agency_automation_rules_link");
        wait.wait_for_second(5);
        verify.element_is_present("cs_agency_current_tab_on_focus");
        verify.element_text_is_equal_to("cs_agency_current_tab_on_focus", "Automation Rules");
    }

    public void verify_tab_is_empty(){
        verify.element_is_present("empty_tab_text");
        verify.element_text_is_equal_to("empty_tab_text", "Nothing to show.");
    }

    public void click_on_bulk_operations_link(){
        verify.element_is_present("cs_agency_bulk_operations_link");
        element.click("cs_agency_bulk_operations_link");
        wait.wait_for_second(5);
        verify.element_is_present("cs_agency_current_tab_on_focus");
        verify.element_text_is_equal_to("cs_agency_current_tab_on_focus", "Bulk Operations");
    }

    public void click_on_integrations_link(){
        verify.element_is_present("cs_agency_integration_link");
        element.click("cs_agency_integration_link");
        WebElement focus = element.find("cs_agency_current_tab_on_focus");
        while(!focus.getText().equals("Integration")){
            focus = element.find("cs_agency_current_tab_on_focus");;
        }
        verify.element_text_is_equal_to("cs_agency_current_tab_on_focus", "Integration");
    }

    public void click_on_info_link(){
        verify.element_is_present("cs_agency_info_link");
        element.click("cs_agency_info_link");
        wait.wait_for_second(3);
        verify.element_is_present("cs_agency_current_tab_on_focus");
        verify.element_text_is_equal_to("cs_agency_current_tab_on_focus", "Info");
    }

    public void click_on_disciplines_link(){
        wait.wait_until_element_is_visible("cs_agency_disciplines_link");
        verify.element_is_present("cs_agency_disciplines_link");
        element.click("cs_agency_disciplines_link");
        WebElement focus = element.find("cs_agency_current_tab_on_focus");
        while(!focus.getText().equals("Disciplines")){
            focus = element.find("cs_agency_current_tab_on_focus");;
        }
        verify.element_text_is_equal_to("cs_agency_current_tab_on_focus", "Disciplines");
    }

    public void click_on_locations_link(){
        verify.element_is_present("cs_agency_locations_link");
        element.click("cs_agency_locations_link");
        WebElement focus = element.find("cs_agency_current_tab_on_focus");
        while(!focus.getText().equals("Locations")){
            focus = element.find("cs_agency_current_tab_on_focus");;
        }
        verify.element_text_is_equal_to("cs_agency_current_tab_on_focus", "Locations");
    }

    public void click_on_select_operation_type_dropdown(){
        verify.element_is_present("bulk_operation_type_dropdown");
        element.click("bulk_operation_type_dropdown");
        wait.wait_for_second(5);
    }

    public void select_terminate_employee_option(){
        click_on_select_operation_type_dropdown();
        verify.element_is_present("terminate_employee_option");
        element.click("terminate_employee_option");
        wait.wait_for_second(5);
    }

    public void select_remove_emp_from_program_option(){
        verify.element_is_present("bulk_operation_type_dropdown");
        element.click("bulk_operation_type_dropdown");
        wait.wait_for_second(4);
        verify.element_is_present("remove_employee_option");
        element.click("remove_employee_option");
    }

    public void select_program(){
        verify.element_is_present("bulk_operation_program_dropdown");
        element.click("bulk_operation_program_dropdown");
        wait.wait_for_second(4);
        verify.element_is_present("bulk_operation_program_option");
        element.click("bulk_operation_program_option");
    }

    public void click_on_identifier_type_dropdown(){
        element.perform_scroll_to_element("bulk_operation_identifier_type_dropdown");
        element.click("bulk_operation_identifier_type_dropdown");
        wait.wait_for_second(5);
    }

    public void select_phone_number_identifier(){
        element.perform_scroll_to_element("employee_phone_identifier");
        verify.element_is_present("employee_phone_identifier");
        element.click("employee_phone_identifier");
        wait.wait_for_second(5);
    }

    public void select_employee_number_identifier(){
        element.perform_scroll_to_element("employee_number_identifier");
        verify.element_is_present("employee_number_identifier");
        element.click("employee_number_identifier");
    }

    public void process_to_remove_employee_by_employee_number(program_page programPage){
        select_remove_emp_from_program_option();
        select_program();
        element.perform_scroll_to_element("bulk_operation_identifier_type_dropdown");
        element.click("bulk_operation_identifier_type_dropdown");
        wait.wait_for_second(5);
        element.perform_scroll_to_element("employee_number_identifier");
        verify.element_is_present("employee_number_identifier");
        element.click("employee_number_identifier");
        List<String> empNums = programPage.get_employee_numbers();
        for(String number: empNums){
            element.enter_text("identifier_text_field", number);
            element.find("identifier_text_field").sendKeys(Keys.ENTER);
        }
        click_on_continue_to_complete_operation();
    }

    public void process_to_remove_employee_by_employee_phone(program_page programPage){
        select_remove_emp_from_program_option();
        select_program();
        element.perform_scroll_to_element("bulk_operation_identifier_type_dropdown");
        element.click("bulk_operation_identifier_type_dropdown");
        wait.wait_for_second(5);
        element.perform_scroll_to_element("employee_phone_identifier");
        verify.element_is_present("employee_phone_identifier");
        element.click("employee_phone_identifier");
        List<String> empPhoneNums = programPage.get_employee_phone_numbers();
        for(String number: empPhoneNums){
            element.enter_text("identifier_text_field", number);
            element.find("identifier_text_field").sendKeys(Keys.ENTER);
        }
        click_on_continue_to_complete_operation();
    }

    public void click_on_continue_to_complete_operation(){
        element.perform_scroll_to_element("bulk_operation_submit");
        verify.element_is_enable("bulk_operation_submit");
        element.click("bulk_operation_submit");
        wait.wait_for_second(5);
    }

    public void verify_summary_page_for_remove_emp_operation(){
        verify.element_is_present("operation_summary_heading");
        verify.element_text_is_equal_to("operation_errors", "0");
    }

    public void verify_error_messages(String errors){
        List<String> actualErrors = element.find_multiple_elements("error_messages_text").stream().map(item-> item.getText()).collect(Collectors.toList());
        System.out.println(actualErrors);
        String errorStream = "";
        for(String err: actualErrors){
            errorStream+=err;
        }
        String error = errors.replaceAll(",", "");
        Assert.assertTrue(errorStream.equals(error));
    }

    public void verify_employees_link(){
        wait.wait_until_element_is_visible("employee_page_link");
        verify.element_is_present("employee_page_link");
    }

    public void click_on_employees_link(){
        wait.wait_until_element_is_visible("employee_page_link");
        element.click("employee_page_link");
        wait.wait_for_second(5);
    }

    public void process_to_terminate_employee_by_phone(employee_action empAction){
        select_terminate_employee_option();
        click_on_identifier_type_dropdown();
        select_phone_number_identifier();
        String empPhone = empAction.get_emp_phone();
        element.enter_text("identifier_text_field", empPhone);
        click_on_continue_to_complete_operation();
    }

    public void process_to_terminate_employee_by_employee_number(employee_action empAction){
        select_terminate_employee_option();
        click_on_identifier_type_dropdown();
        select_employee_number_identifier();
        String empNumber = empAction.get_emp_number();
        element.enter_text("identifier_text_field", empNumber);
        click_on_continue_to_complete_operation();
    }

    public void verify_summary_page_after_terminating_employee(){
        verify.element_is_present("operation_summary_heading");
        verify.element_text_is_equal_to("operation_errors", "0");
    }

    public void select_identifier_type_as_phone_and_give_employee_number_in_the_field(Object obj){
        click_on_identifier_type_dropdown();
        select_phone_number_identifier();
        String empNumber = "";
        if(obj instanceof employee_action){
            empNumber = ((employee_action) obj).get_emp_number();
        }
        if(obj instanceof program_page){
            empNumber = ((program_page) obj).get_employee_number();
        }
        element.perform_scroll_to_element("identifier_text_field");
        element.enter_text("identifier_text_field", empNumber);
        click_on_continue_to_complete_operation();
    }

    public void select_identifier_type_as_employee_number_and_give_phone_number_in_the_field(Object obj){
        click_on_identifier_type_dropdown();
        select_employee_number_identifier();
        String empPhone = "";
        if(obj instanceof employee_action){
            empPhone = ((employee_action) obj).get_emp_phone();
        }
        if(obj instanceof program_page){
            empPhone = ((program_page) obj).get_employee_phone();
        }
        element.perform_scroll_to_element("identifier_text_field");
        element.enter_text("identifier_text_field", empPhone);
        click_on_continue_to_complete_operation();
    }

    public void verify_operation_not_successfull(){
        verify.element_is_present("operation_summary_heading");
        Assert.assertTrue(Integer.valueOf(element.get_element_text("operation_errors"))>0);
    }

    public void verify_agency_not_integrated_with_partner_on_integration_page(){
        wait.wait_until_element_is_visible("empty_integration_tab");
        verify.element_is_present("empty_integration_tab");
        verify.element_text_is_equal_to("empty_integration_tab", "No integration.");
    }

    public void verify_agency_not_integrated_with_partner_on_info_page(){
        element.perform_scroll_to_element("integration_label_on_info_page");
        verify.element_is_present("empty_integration_on_info");
        verify.element_text_is_equal_to("empty_integration_on_info", "No integration");
    }

    public void verify_presence_of_new_discipline_button_on_new_disciplines_tab(){
        try {
            Assert.assertTrue(verify.check_element_is_present("new_discipline_button"));
        }
        catch(Exception ex){
            System.out.println("New Discipline button not present as expected");
        }
    }

    public void verify_presence_of_new_location_button_on_new_locations_tab(){
        try {
            Assert.assertTrue(verify.check_element_is_present("new_location_button"));
        }
        catch(Exception ex){
            System.out.println("New Location button not present as expected");
        }
    }

    public void verify_absence_of_new_location_button_on_new_locations_tab(){
        try {
            Assert.assertFalse(verify.check_element_is_present("new_location_button"));
        }
        catch(Exception ex){
            System.out.println("New Location button not present as expected");
        }
    }

    public void verify_absence_of_new_discipline_button_on_new_disciplines_tab(){
        try {
            Assert.assertFalse(verify.check_element_is_present("new_discipline_button"));
        }
        catch(Exception ex){
            System.out.println("New Location button not present as expected");
        }
    }

    public void click_on_integrate_with_dropdown(){
        verify.element_is_present("integration_partners_dropdown");
        element.click("integration_partners_dropdown");
        wait.wait_for_second(5);
    }

    public void verify_integration_changed_successfully(){
        wait.wait_until_element_is_visible("partner_changed_message_pop_up");
        verify.element_is_present("partner_changed_message_pop_up");
        verify.element_text_is_equal_to("partner_changed_message_pop_up", "Integration partner changed successfully.");
    }

    public List<WebElement> get_partner_options(){
        return element.find_multiple_elements("integration_partners_list");
    }

    public void select_given_integration_partner(String partnerName){
        click_on_integrate_with_dropdown();
        List<WebElement> lstOfPartners = get_partner_options();
        for(WebElement integrationPartner: lstOfPartners){
            if(integrationPartner.getText().equals(partnerName)){
                integrationPartner.click();
                break;
            }
        }
        verify_integration_changed_successfully();
    }

    public void verify_mandatory_fields_error_for_alayacare_and_smartcare_partner(String errors){
        Assert.assertTrue(errors.contains(driver.findElement(By.xpath("//input[@id='integration-host']"+postFixToIntegrationTextBoxLocators)).getText()));
        Assert.assertTrue(errors.contains(driver.findElement(By.xpath("//input[@id='integration-user']"+postFixToIntegrationTextBoxLocators)).getText()));
        Assert.assertTrue(errors.contains(driver.findElement(By.xpath("//input[@id='integration-password']"+postFixToIntegrationTextBoxLocators)).getText()));
    }

    public void verify_mandatory_fields_error_for_axiscare_partner(String errors){
        Assert.assertTrue(errors.contains(driver.findElement(By.xpath("//input[@id='integration-host-0']/parent::div/following-sibling::div/descendant::span[contains(@class, 'p-error')]")).getText()));
        Assert.assertTrue(errors.contains(driver.findElement(By.xpath("//input[@id='integration-token']"+postFixToIntegrationTextBoxLocators)).getText()));
    }

    public void verify_mandatory_fields_error_for_hhaexchange_partner(String errors){
        Actions action = new Actions(driver);
        Assert.assertTrue(errors.contains(driver.findElement(By.xpath("//input[@id='integration-hhax-agency-id']"+postFixToIntegrationTextBoxLocators)).getText()));
        Assert.assertTrue(errors.contains(driver.findElement(By.xpath("//input[@id='integration-host']"+postFixToIntegrationTextBoxLocators)).getText()));
        Assert.assertTrue(errors.contains(driver.findElement(By.xpath("//input[@id='integration-host-custom']"+postFixToIntegrationTextBoxLocators)).getText()));
        action.moveToElement(driver.findElement(By.xpath("//input[@id='integration-app-key']"+postFixToIntegrationTextBoxLocators))).perform();
        Assert.assertTrue(errors.contains(driver.findElement(By.xpath("//input[@id='integration-app-key']"+postFixToIntegrationTextBoxLocators)).getText()));
        action.moveToElement(driver.findElement(By.xpath("//input[@id='integration-app-secret']"+postFixToIntegrationTextBoxLocators))).perform();
        Assert.assertTrue(errors.contains(driver.findElement(By.xpath("//input[@id='integration-app-secret']"+postFixToIntegrationTextBoxLocators)).getText()));
        action.moveToElement(driver.findElement(By.xpath("//input[@id='integration-app-name']"+postFixToIntegrationTextBoxLocators))).perform();
        Assert.assertTrue(errors.contains(driver.findElement(By.xpath("//input[@id='integration-app-name']"+postFixToIntegrationTextBoxLocators)).getText()));
    }

    public void click_on_save_button_on_integration_tab(){
        verify.element_is_present("integration_partner_save_button");
        element.click("integration_partner_save_button");
        wait.wait_for_second(2);
    }

    public void select_integration_partner_and_verify_partner_changed_successfully(){
        click_on_integrate_with_dropdown();
        List<WebElement> lstOfPartners = get_partner_options();
        WebElement partner = lstOfPartners.get((int)(Math.random()*(lstOfPartners.size())));
        map.put("Integration Partner", partner.getText());
        partner.click();
        wait.wait_for_second(2);
        verify_integration_changed_successfully();
    }

    public void verify_integration_on_info_page_when_partner_integrated_with_agency(){
        element.perform_scroll_to_element("integration_label_on_info_page");
        verify.element_is_present("integration_page_link_on_info");
        verify.element_text_is_equal_to("partner_name_on_info_page", map.get("Integration Partner"));
    }

    public void verify_integration_partner_is_integrated_with_agency(){
        Assert.assertFalse(verify.check_element_is_present("empty_integration_tab"));
    }

    public boolean partner_integrated_with_agency(){
        return verify.check_element_is_present("empty_integration_tab");
    }

    public void click_on_edit_button_on_settings_page(){
        verify.element_is_present("integration_partner_edit_button");
        element.click("integration_partner_edit_button");
        wait.wait_for_second(3);
    }

    public void verify_presence_of_remove_integration_button(){
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertTrue(verify.check_element_is_present("remove_integration_button"));
    }

    public void verify_absence_of_remove_integration_button(){
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertFalse(verify.check_element_is_present("remove_integration_button"));
    }

    public void click_on_cancel_from_integration_page(){
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        verify.element_is_present("integration_partner_cancel_button");
        element.click("integration_partner_cancel_button");
        wait.wait_for_second(3);
    }

    public void remove_integration_from_agency(){
        element.perform_scroll_to_element("remove_integration_button");
        element.click("remove_integration_button");
        wait.wait_until_element_is_visible("remove_integration_pop_up_header");
        verify.element_is_present("remove_integration_pop_up_header");
        verify.element_text_is_equal_to("remove_integration_pop_up_header", "Remove Integration");
        element.click("remove_button_on_remove_integration_pop_up");
        wait.wait_for_second(3);
    }

    public void click_on_cs_logo(){
        element.click("cs_logo");
        wait.wait_for_second(5);
    }

    public String get_partner_name_of_integration_page(){
        return element.get_element_text("integration_partner_header");
    }
    public void enter_values_in_fields_of_alayacare_and_smartcare(String[] inputs){
        verify.element_is_present("integration_host_field");
        element.clear_and_enter_in_text_field("integration_host_field", inputs[0]);
        verify.element_is_present("integration_user_field");
        element.clear_and_enter_in_text_field("integration_user_field", inputs[1]);
        verify.element_is_present("integration_password_field");
        element.clear_and_enter_in_text_field("integration_password_field", inputs[2]);
    }

    public void enter_values_in_fields_of_axiscare(String[] inputs){
        verify.element_is_present("integration_token_field");
        element.clear_and_enter_in_text_field("integration_token_field", inputs[0]);
        verify.element_is_present("integration_host_field_for_axiscare");
        element.clear_and_enter_in_text_field("integration_host_field_for_axiscare", inputs[1]);
    }

    public void enter_values_in_fields_of_hhaexchange(String[] inputs){
        verify.element_is_present("integration_hhax_agency_id_field");
        element.clear_and_enter_in_text_field("integration_hhax_agency_id_field", inputs[0]);
        verify.element_is_present("integration_host_field");
        element.clear_and_enter_in_text_field("integration_host_field", inputs[1]);
        verify.element_is_present("integration_host_custom_field");
        element.clear_and_enter_in_text_field("integration_host_custom_field", inputs[2]);
        verify.element_is_present("integration_app_key_field");
        element.clear_and_enter_in_text_field("integration_app_key_field", inputs[3]);
        verify.element_is_present("integration_app_secret_field");
        element.clear_and_enter_in_text_field("integration_app_secret_field", inputs[4]);
        element.perform_scroll_to_element("integration_app_name_field");
        verify.element_is_present("integration_app_name_field");
        element.clear_and_enter_in_text_field("integration_app_name_field", inputs[5]);
    }

    public void verify_integration_changes_are_successfull(){
        verify.element_is_present("integration_settings_updated");
    }

    public void click_on_open_integration_settings_from_info_tab(){
        element.perform_scroll_to_element("integration_settings_link_on_info_tab");
        verify.element_is_present("integration_settings_link_on_info_tab");
        map.put("Integration Partner on Info", element.get_element_text("partner_name_on_info_page"));
        element.click("integration_settings_link_on_info_tab");
        wait.wait_for_second(3);
    }

    public void verify_user_is_on_integration_tab_and_name_is_same_as_info_tab(){
        Assert.assertEquals(element.get_element_text("integration_partner_header").toLowerCase(), map.get("Integration Partner on Info").toLowerCase());
    }

    public void click_on_partners_list_dropdown(){
        element.perform_scroll_to_element("integration_partners_dropdown_on_info");
        verify.element_is_present("integration_partners_dropdown_on_info");
        element.click("integration_partners_dropdown_on_info");
    }

    public List<WebElement> get_partners_options_in_info_tab(){
        return element.find_multiple_elements("integration_partners_list_on_info_tab");
    }

    public void select_integration_partner_from_info_tab(){
        Actions action = new Actions(driver);
        click_on_partners_list_dropdown();
        List<WebElement> lstOfPartners = get_partners_options_in_info_tab();
        WebElement partner = lstOfPartners.get((int)(Math.random()*(lstOfPartners.size())));
        while(partner.getText().equals("None")){
            partner = lstOfPartners.get((int)(Math.random()*(lstOfPartners.size())));
        }
        map.put("Integration Partner on Info", partner.getText());
        action.moveToElement(partner).click().perform();
        wait.wait_for_second(2);
    }

    public void click_on_update_button(){
        wait.wait_until_element_is_clickable("update_info_button");
        element.click("update_info_button");
        wait.wait_for_second(2);
    }

    public void verify_update_succeed_on_info_page(){
        verify.element_is_present("update_successful_message_on_info");
    }

    public void select_none_from_partner_list_from_info_tab(){
        element.perform_scroll_to_element("none_option_in_partners_list");
        verify.element_is_present("none_option_in_partners_list");
        element.click("none_option_in_partners_list");
    }

    public void clear_all_the_input_fields(){
        Actions action = new Actions(driver);
        List<WebElement> lstOfInputFields = element.find_multiple_elements("partner_input_fields");
        for(WebElement ele: lstOfInputFields){
            action.moveToElement(ele).perform();
            ele.sendKeys(Keys.chord(Keys.CONTROL,"a"));
            ele.sendKeys(Keys.DELETE);
        }
    }

    public void remove_integration_if_any(){
        try{
            if(verify.check_element_is_present("integration_partner_edit_button")){
                click_on_edit_button_on_settings_page();
                verify_presence_of_remove_integration_button();
                remove_integration_from_agency();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void add_integration_if_not_present(){
        try{
            if(verify.check_element_is_present("empty_integration_tab")){
                select_integration_partner_and_verify_partner_changed_successfully();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void add_integration_from_info_tab_if_not_present(){
        try{
            element.perform_scroll_to_element("integration_label_on_info_page");
            if(verify.check_element_is_present("empty_integration_on_info")){
                click_on_edit_button_on_settings_page();
                select_integration_partner_from_info_tab();
                click_on_update_button();
                verify_update_succeed_on_info_page();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
