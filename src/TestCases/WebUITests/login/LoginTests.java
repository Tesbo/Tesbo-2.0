package TestCases.WebUITests.login;



import Framework.core.init.base;
import Framework.core.readers.DataReader;
import Framework.core.readers.JsonFileReader;
import Framework.core.remotegrid.LambdaTestConfig;

import TestObjects.Pages.login.login_page;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import utility.Logger;


public class LoginTests extends base {
    login_page test;

    @Test
    public void verify_facebook_opening(){
        test= new login_page(driver);
        test.verify_facebook_opening();
    }
}
