package web.test.login;

import io.unity.framework.init.base;
import org.testng.annotations.Test;
import web.object_repository.login_page.login_steps;

public class login_tests extends base {


    @Test
    public void verify_login_page()
    {
        System.out.println("login Test");

        login_steps login_page_steps = new login_steps(driver);

        login_page_steps.verify_email_is_present_on_page();
        login_page_steps.enter_text_at_email("niharika+retest@linearloop.io");
        login_page_steps.verify_password1_is_present_on_page();
        login_page_steps.clear_text_and_enter_text_in_password1("Test@123");
        login_page_steps.verify_signIn_is_clickable();
        login_page_steps.click_on_signIn();



    }

}
