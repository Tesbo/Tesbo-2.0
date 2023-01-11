package web.tests;

import io.unity.framework.init.base;
import org.testng.annotations.Test;
import web.object_repository.login.login;

public class LoginTest extends base {

    @Test
    public void verify_user_should_be_able_to_create_sequence() {

        login login = new login(driver);
        driver.manage().window().maximize();
        login.login();

        login.click_on_sequence_menu();
        login.click_on_create_sequence_button();
        login.click_on_add_step_button();
        login.enter_text_at_enter_subject("Test");
        login.enter_text_at_enter_description("Hi greetings from QAble.keep joining us Thanks");
        login.click_on_sequence_save_button();
        login.click_on_sequence_menu();

    }

}
