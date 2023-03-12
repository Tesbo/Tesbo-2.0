package mobile.tests.HomeScreen;

import io.appium.java_client.AppiumDriver;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.automob.Device;
import io.unity.performaction.autoweb.Wait;
import io.unity.performaction.autoweb.testng_logs;
import mobile.object_repository.cardControlChangeCardPin.changeCardPin;
import mobile.object_repository.cardControlPage.cardControlPage;
import mobile.object_repository.controlPanelScreen.controlPanelScreen;
import mobile.object_repository.explore.explore;
import mobile.object_repository.homeScreenPage.HomeScreenOffersPage;
import mobile.object_repository.homeScreenPage.homeScreen;
import mobile.object_repository.homeScreenPage.homeScreenPage;
import mobile.object_repository.homeScreenPage.requestPhysicalCardPopup;
import mobile.object_repository.setUpAutoPayPage.setUpAutopayPage;
import mobile.object_repository.tranactionHomePage.transactionHomePage;
import mobile.object_repository.transactionSpendsTabPage.transactionSpendsOverviewTabPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeScreenTest extends base {

    controlPanelScreen controlPanelScreen = null;
    transactionHomePage transactionHomePage = null;
    HomeScreenOffersPage offersPage = null;
    changeCardPin changepin = null;
    transactionSpendsOverviewTabPage overviewTabPage = null;
    setUpAutopayPage autopayPage = null;
    requestPhysicalCardPopup physicalCardPopup =null;
    homeScreenPage homeScreenpage= null;

    cardControlPage cardcontrol = null;

    homeScreen homescreen = null;
    Wait wait = null;
    Device device = null; //new Device((AppiumDriver)driver);

    testng_logs logs = new testng_logs();

    @Test
    public void verify_all_the_option_present_on_page() {

        //TCS3_01
        logs.test_step("<b>Covering Test Cases TCS3_01 : </b> <br><br>");

        controlPanelScreen = new controlPanelScreen(driver);
        transactionHomePage = new transactionHomePage(driver);
        homescreen = new homeScreen(driver);
        wait = new Wait(driver);
        device = new Device((AppiumDriver) driver);

        homescreen.verify_homeScreen_bnpl_card_text_is_equal_to("BNPL CARD");
        homescreen.verify_see_card_button_text_is_present_on_page();
        homescreen.verify_pay_now_home_screen_button_is_present_on_page();

        try {
            homescreen.check_enable_online_card_button_is_present();
            device.scroll_down();
            device.scroll_down();
            homescreen.verify_set_Pin_btn();
            device.scroll_down();
            device.scroll_down();
            homescreen.verify_go_Contactless_Enable_Btn();
        }catch (Exception e){
            logs.test_step("enable_online_card_button is not present in screen");
//            e.printStackTrace();
        }

    }
    @DataProvider(name = "Entering Custom Amount")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Kotak_data_provider.xlsx", 0);
        return data;
    }

   /* @Test(dataProvider = "Entering Custom Amount")
    public void verify_monthly_statement(String pay_custom_amount) {

        controlPanelScreen = new controlPanelScreen(driver);
        transactionHomePage = new transactionHomePage(driver);
        overviewTabPage = new transactionSpendsOverviewTabPage(driver);
        homescreen = new homeScreen(driver);
        wait = new Wait(driver);

        homescreen.click_on_pay_now_home_screen_button();
        overviewTabPage.verify_pay_in_full_textbox_is_present_on_page();
        overviewTabPage.verify_pay_custom_amount_textbox_is_present_on_page();
        overviewTabPage.click_on_pay_custom_amount_textbox();
        overviewTabPage.verify_repayment_continue_button_is_disable();
        overviewTabPage.clear_text_and_enter_text_in_pay_custom_amount_textbox(".");
        wait.wait_for_second(2);
        overviewTabPage.clear_text_and_enter_text_in_pay_custom_amount_textbox_data_provider(pay_custom_amount);
    }
*/
  /*  @Test
    public void verify_enable_online_card_payment() {

        controlPanelScreen = new controlPanelScreen(driver);
        transactionHomePage = new transactionHomePage(driver);
        overviewTabPage = new transactionSpendsOverviewTabPage(driver);
        controlPanelScreen = new controlPanelScreen(driver);
        cardcontrol = new cardControlPage(driver);
        homescreen = new homeScreen(driver);
        wait = new Wait(driver);
        device = new Device((AppiumDriver) driver);

        try {
            homescreen.check_enable_online_card_button_is_present();
            homescreen.click_on_enable_online_card_button();
            controlPanelScreen.click_on_back_button();
            homescreen.click_on_enable_online_card_button();
            cardcontrol.click_on_online_transaction_toggle();
            controlPanelScreen.click_on_back_button();
        }catch (Exception e){
            logs.test_step("enable_online_card_button is not present in screen");
//            e.printStackTrace();
        }
    }

    @Test
    public void verify_set_card_pin() {

        //TCS3_37,38
        logs.test_step("<b>Covering Test Cases TCS3_37 - TCS3_38 : </b> <br><br>");

        controlPanelScreen = new controlPanelScreen(driver);
        transactionHomePage = new transactionHomePage(driver);
        overviewTabPage = new transactionSpendsOverviewTabPage(driver);
        homescreen = new homeScreen(driver);
        changepin = new changeCardPin(driver);
        device = new Device((AppiumDriver)driver);
        wait = new Wait(driver);

        wait.wait_for_second(10);
        device.scroll_down();
//        device.scroll_down();
        try {

            homescreen.check_set_card_pin_is_present();
            homescreen.verify_set_pin_button_is_present_on_page();
            homescreen.click_on_set_pin_button();
            homescreen.click_on_set_pin_popup_button();

//            wait.wait_for_second(1);
            changepin.enter_pin("1234");
            changepin.re_enter_pin("1111");

            changepin.clear_text_and_enter_text_in_re_enter_new_pin_text_box("1234");
            changepin.click_on_change_pin_screen_confirm_pin_button();
            changepin.verify_success_done_button_is_present_on_page();
            changepin.click_on_success_done_button();
        }catch (Exception e){
            logs.test_step("set_pin_button is not present in screen");
//            e.printStackTrace();
        }
    }

    @Test
    public void verify_go_contactless() {

        //TCS3_44,45,46,
        logs.test_step("<b>Covering Test Cases TCS3_44 - TCS3_46 : </b> <br><br>");

        controlPanelScreen = new controlPanelScreen(driver);
        cardcontrol = new cardControlPage(driver);
        transactionHomePage = new transactionHomePage(driver);
        overviewTabPage = new transactionSpendsOverviewTabPage(driver);
        homescreen = new homeScreen(driver);
        wait = new Wait(driver);
        device = new Device((AppiumDriver) driver);

        wait.wait_for_second(5);
        device.scroll_down();

        try {

            homescreen.check_get_contactless_is_present();
            homescreen.verify_get_contactless_button_is_present_on_page();
            homescreen.click_on_get_contactless_button();

            cardcontrol.verify_card_control_title_is_present_on_page();
            controlPanelScreen.click_on_back_button();

//            homescreen.verify_get_contactless_button_is_present_on_page();

            homescreen.click_on_enable_online_card_button();
            cardcontrol.click_on_contactless_payments_toggle();
//            homescreen.verify_get_contactless_button_is_present_on_page();
        }catch (Exception e){
            logs.test_step("get_contactless_button is not present");
//            e.printStackTrace();
        }

    }

    @Test
    public void to_verify_Request_Physical_card_nudge_card()
    {
        transactionHomePage = new transactionHomePage(driver);
        homeScreenpage = new homeScreenPage(driver);
        offersPage =new HomeScreenOffersPage(driver);
        physicalCardPopup = new requestPhysicalCardPopup(driver);
        device = new Device((AppiumDriver)driver);
        homescreen = new homeScreen(driver);
        wait = new Wait(driver);

        //TCS3_70,71,72,73,74,75,76
        logs.test_step("<b>Covering Test Cases TCS3_70 - TCS3_76 : </b> <br><br>");

        wait.wait_for_second(5);
        device.scroll_down();
//        device.scroll_down();
        try {
            homescreen.check_get_card_is_present();
            homeScreenpage.verify_request_physical_card_text_text_is_equal_to("Request physical card");
            homeScreenpage.verify_request_physical_card_get_card_button_is_present_on_page();
            homeScreenpage.click_on_request_physical_card_get_card_button();

            physicalCardPopup.verify_request_physical_card_popup_close_button_is_present_on_page();
            physicalCardPopup.click_on_request_physical_card_popup_close_button();
//            homeScreenpage.verify_request_physical_card_get_card_button_is_present_on_page();

            homeScreenpage.click_on_request_physical_card_get_card_button();

            physicalCardPopup.verify_request_physical_card_popup_proceed_button_is_present_on_page();

            physicalCardPopup.click_on_request_physical_card_popup_proceed_button();
            physicalCardPopup.verify_confirm_your_address_text_text_is_equal_to("Confirm your address");

            physicalCardPopup.verify_confirm_address_button_is_present_on_page();

            physicalCardPopup.click_on_confirm_address_button();
            physicalCardPopup.verify_success_screen_message_text_is_equal_to("Your card is on its way");

            physicalCardPopup.verify_success_screen_done_button_is_present_on_page();
            physicalCardPopup.click_on_success_screen_done_button();

            transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        }catch (Exception e){
            logs.test_step("request_physical_card is not present");
//            e.printStackTrace();
        }

    }

    @Test
    public void verify_One_card_with_many_benefits_nudge_card_functionality()
    {
        //TCS3_79
        logs.test_step("<b>Covering Test Cases TCS3_79 : </b> <br><br>");

        homeScreenpage = new homeScreenPage(driver);
        device = new Device((AppiumDriver) driver);
        wait = new Wait(driver);

        wait.wait_for_second(5);
        device.scroll_down();
        device.scroll_down();
//        device.scroll_down();
//        device.scroll_down();
//        device.scroll_down();
        homeScreenpage.verify_one_card_with_many_benefits_nudge_card_is_present_on_page();
        homeScreenpage.Verify_one_card_with_many_benefits_nudge_card_text_is_equal_to("One card with many benefits");
    }

    @Test
    public void verify_Home_Exclusive_offers_functionality()
    {
        //TCS3_80,82,83,84,85,86,87
        logs.test_step("<b>Covering Test Cases TCS3_80, TCS3_82 - TCS3_87 : </b> <br><br>");

        transactionHomePage = new transactionHomePage(driver);
        homeScreenpage = new homeScreenPage(driver);
        offersPage =new HomeScreenOffersPage(driver);
        physicalCardPopup = new requestPhysicalCardPopup(driver);
        wait = new Wait(driver);


        homeScreenpage.move_To_Exclusive_Offers();
        wait.wait_for_second(2);
        homeScreenpage.verify_offerCard_tile_1_is_present_on_page();
        homeScreenpage.click_on_offerCard_tile_1();

        offersPage.verify_redeem_offer_cta_is_present_on_page();

        offersPage.verify_offers_valid_date_text_is_equal_to("VALID TILL DEC 31, 2023");

        offersPage.verify_redemption_link_text_is_equal_to("https://fullsteamcoffeeshop.com");
        // offersPage.click_on_redemption_link_button();

        offersPage.verify_coupon_code_text_text_is_equal_to("BLK150");

        offersPage.verify_coupon_code_copy_button_is_present_on_page();
        offersPage.click_on_coupon_code_copy_button();

        offersPage.verify_redeem_offer_cta_is_present_on_page();

        offersPage.verify_offerPage_back_button_is_present_on_page();
        offersPage.click_on_offerPage_back_button();

        //For checking all the Cta Offers available
//        homeScreenpage.Horizontal_moving_offer_cards();


        homeScreenpage.click_on_offerCard_tile_1();

        offersPage.click_on_redeem_offer_cta();

    }

    @Test
    public void verify_Offers_on_brands_section()
    {
        //TCS3_88,90,91,93,94,95
        logs.test_step("<b>Covering Test Cases TCS3_88, TCS3_90, TCS3_91, TCS3_93 - TCS3_95 : </b> <br><br>");

        transactionHomePage = new transactionHomePage(driver);
        homeScreenpage = new homeScreenPage(driver);
        offersPage =new HomeScreenOffersPage(driver);
        physicalCardPopup = new requestPhysicalCardPopup(driver);
        device = new Device((AppiumDriver) driver);

        homeScreenpage.move_To_Offers_On_Brands();
        homeScreenpage.verify_offers_on_brands_tile_1_is_present_on_page();
        homeScreenpage.click_on_offers_on_brands_tile_1();

        offersPage.verify_redeem_offer_cta_is_present_on_page();

        offersPage.verify_offers_valid_date_text_is_equal_to("VALID TILL DEC 31, 2023");

        offersPage.verify_redemption_link_text_is_equal_to("https://fullsteamcoffeeshop.com");
       // offersPage.click_on_redemption_link_button();

        offersPage.verify_coupon_code_text_text_is_equal_to("BLK150");
        offersPage.click_on_coupon_code_copy_button();

        offersPage.verify_redeem_offer_cta_is_present_on_page();
        offersPage.click_on_offerPage_back_button();

        homeScreenpage.click_on_offers_on_brands_tile_1();

        offersPage.click_on_redeem_offer_cta();

    }

    @Test
    public void verify_all_the_icon_are_present_in_home_screen()
    {
        //TCS3_01,
        logs.test_step("<b>Covering Test Cases TCS3_01 : </b> <br><br>");
        transactionHomePage = new transactionHomePage(driver);
        homeScreenpage = new homeScreenPage(driver);
        offersPage =new HomeScreenOffersPage(driver);
        physicalCardPopup = new requestPhysicalCardPopup(driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        transactionHomePage.verify_card_see_card_button_is_present_on_page();
        transactionHomePage.click_on_card_see_card_button();



    }


    @Test
    public void verify_get_Offers_Horizontal_scroll()
    {
        transactionHomePage = new transactionHomePage(driver);
        homeScreenpage = new homeScreenPage(driver);
        offersPage =new HomeScreenOffersPage(driver);
        device = new Device((AppiumDriver) driver);
        physicalCardPopup = new requestPhysicalCardPopup(driver);
        wait = new Wait(driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        homeScreenpage.move_To_Exclusive_Offers();

        homeScreenpage.Horizontal_moving_offer_cards();

    }

    @Test
    public void verify_On_Brands_Offers_Horizontal_scroll()
    {
        transactionHomePage = new transactionHomePage(driver);
        homeScreenpage = new homeScreenPage(driver);
        offersPage =new HomeScreenOffersPage(driver);
        device = new Device((AppiumDriver) driver);
        physicalCardPopup = new requestPhysicalCardPopup(driver);
        wait = new Wait(driver);

        transactionHomePage.verify_home_hamburger_button_is_present_on_page();
        homeScreenpage.move_To_Offers_On_Brands();

        homeScreenpage.Horizontal_moving_offers_on_brands_cards();

    }*/



}