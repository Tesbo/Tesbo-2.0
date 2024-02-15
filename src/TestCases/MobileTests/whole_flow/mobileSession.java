package MobileTests.whole_flow;//package mobile.tests.whole_flow;
//
//import io.unity.framework.data.TestData;
//import io.unity.framework.init.Session;
//import io.unity.framework.init.base;
//import io.unity.performaction.autoweb.Element;
//import io.unity.performaction.autoweb.Verify;
//import io.unity.performaction.autoweb.Wait;
//import mobile.object_repository.login.login_screen;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;
//import web.object_repository.new_panel.login.login_page;
//
//
//public class mobileSession extends base
//{
//    String userEmailID = "qabletest+"+ TestData.random_numeric_string(3)+"@yopmail.com";
//    String userPassword = "QA_123456";
//    Element element = null;
//    Verify verify = null;
//    Wait wait = null;
//    Session session = null;
//   public mobileSession(){
//       session = new Session();
//       element = new Element(driver);
//       verify = new Verify(driver);
//       wait = new Wait(driver);
//
//   }
//    @Test
//    public void mobTest()
//    {
//        login_screen login_screen = new login_screen(driver);
//        login_screen.verify_okey_button_popup_is_present_on_page();
//        login_screen.click_on_okey_button_popup();
//
//       WebDriver dri = session.create_new_web_session("dev");
//
//        login_page login = new login_page(dri);
//        login.performLogin("viral@nevvon.com","12345a");
//
//       // driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abcd");
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////        session.create_new_web_session("dev");
////
////        login_page login = new login_page(driver);
////        dashboard_page dashboard = new dashboard_page(driver);
////        agency_page agency_home = new agency_page(dri);
////        agencies_page agencies_page = new agencies_page(driver);
////        add_employee_pop_up employee_popup = new add_employee_pop_up(driver);
////        new_employee_create_page employee_personal = new new_employee_create_page(driver);
////        employee_profile_page employee_profile = new employee_profile_page(driver);
//
//
////        element.find("email_text_box").sendKeys("abc");             //not working
//      //  element.find("//input[@name='password']").sendKeys("12345");//not working but
//
////        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@yopmail.com");            // is Working
////        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345a");            // is working
//
//
//
//
//    }
//}
