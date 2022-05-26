package io.unity.framework.generators.locatorgenerator;

import org.openqa.selenium.By;

public class xPathValidator {


    public boolean isxPathIsVisible(String xPath) {
        boolean isVisible = false;
        try {
            if (Browser.driver.findElement(By.xpath(xPath)).isDisplayed()) {
                isVisible = true;
            }
        }catch(Exception e)
        {
            
        }
        return isVisible;
    }


}
