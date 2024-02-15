package Screens.Notification_Page;

import io.unity.core.generators.methodsgenerator.methods.MethodsData;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;

public class notification_Page {

	WebDriver driver = null;
	Element element = null;
	Verify verify = null;
	Wait wait = null;

	public notification_Page(WebDriver driver) {
		this.driver = driver;
		element = new Element(driver);
		verify = new Verify(driver);
		wait = new Wait(driver);
	}

	@MethodsData(method_id = "button_1")
	public void verify_Notification_Text_is_present_on_page() {
	//	wait.wait_until_element_is_visible("home_bottom_button");
		wait.wait_for_second(5);
		verify.element_is_present("notifications_text");
	}
}