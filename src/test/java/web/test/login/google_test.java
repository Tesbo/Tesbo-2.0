package web.test.login;

import io.unity.framework.init.base;
import org.testng.annotations.Test;
import web.object_repository.login_page.search_page;

import java.sql.SQLOutput;

public class google_test extends base {
    
    
    
    @Test
    public void search_page()
    {
        System.out.println("Search Page");
        search_page search_page_step = new search_page(driver);
        search_page_step.click_on_search_text_box();
    }
}
