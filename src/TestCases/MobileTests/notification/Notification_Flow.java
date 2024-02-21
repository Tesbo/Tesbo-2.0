package TestCases.MobileTests.notification;


import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.remotegrid.LambdaTestConfig;
import Screens.Notification_Page.notification_Page;
import Screens.home_screen.home_screen;
import Screens.login.login_screen;
import org.testng.annotations.Test;
import utility.Logger;

import java.time.Duration;

public class Notification_Flow extends base {

    @Test
    public void To_verify_when_tap_on_Notification_tab_it_opens_Notification_page() {

        Logger.log_qase_id("TC_NFA_001");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_tap_on_Notification_tab_it_opens_Notification_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        notification_Page notification_Page = new notification_Page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_Notification_bottom_button_is_present_on_page();
         home_screen.click_on_Notification_bottom_button();
        notification_Page.verify_Notification_Text_is_present_on_page();
    }

    @Test
    public void To_verify_when_sends_message_from_agency_panel() {

        Logger.log_qase_id("TC_NFA_003");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_sends_message_from_agency_panel");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        notification_Page notification_Page = new notification_Page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_Notification_bottom_button_is_present_on_page();
        home_screen.click_on_Notification_bottom_button();
        notification_Page.verify_Notification_Text_is_present_on_page();
    }
}

