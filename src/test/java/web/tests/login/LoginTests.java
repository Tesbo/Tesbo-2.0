package web.tests.login;

import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.framework.readers.json_file_reader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.object_repository.login.login_page;

public class LoginTests extends base {


    @DataProvider(name = "login_credentials")
    public Object[][] data_provider() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;

        System.out.println(config.getEnvFromCurrentConfig());
        if (config.getEnvFromCurrentConfig().contains("test")) {
            data = reader.getExcelDataForDataProvider("nevvon_test_env.xlsx", 1);
        } else if (config.getEnvFromCurrentConfig().contains("admin")) {
            data = reader.getExcelDataForDataProvider("nevvon_prod_env.xlsx", 1);
        }
        return data;
    }

    @Test(dataProvider = "login_credentials")
    public void verify_login_with_valid_user(String username,String password)
    {
        System.out.println("username" +username);
        System.out.println("password" +password);


        login_page login = new login_page(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.enter_text_at_email_text_box("viral@nevvon.com");
        login.enter_text_at_password("123456a");
        login.click_on_login_button();

    }
}
