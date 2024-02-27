package TestCases.WebUITests.login;

import Framework.core.init.base;
import TestObjects.Pages.login.login_page;
import org.testng.annotations.Test;


public class LoginTests extends base {
    login_page test;

    @Test
    public void verify_facebook_opening(){
        test= new login_page(driver);
        test.verify_facebook_opening();
    }
}
