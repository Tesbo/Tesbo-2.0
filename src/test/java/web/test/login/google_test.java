package web.test.login;

import io.unity.framework.init.base;
import org.testng.annotations.Test;
import web.object_repository.login_page.search_page_steps;

public class google_test extends base {
    
    
    
    @Test
    public void search_page()
    {
        search_page_steps search_page_step = new search_page_steps(driver);


        search_page_step.enter_text_at_search_text_box("viral patel");
    }
}
