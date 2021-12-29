package webapptest.login;

import io.unity.object_repository.Web.login.login_page_step;
import io.unity.image_comparison;
import org.testng.annotations.Test;

import io.unity.framework.init.base;

public class login_test extends base {


    login_page_step login_page = null;
    image_comparison compare = null;


    @Test
    public void loginTest() {
        login_page = new login_page_step(driver);
      compare =  new image_comparison(driver);


        login_page.verify_enter_your_email_text_box_is_present_on_page();

        compare.compare_image("homepage");
        login_page.enter_text_at_enter_your_email_text_box("ankitpatel@qable.io");
        login_page.enter_text_at_enter_your_password_password("QAble@2020");
        login_page.click_on_sign_in_button();







    }


    @Test
    public void WebAppTestTwo() {
        System.out.println("Second Web app Test");
    }


}
