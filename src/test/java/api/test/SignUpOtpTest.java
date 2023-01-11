package api.test;

import api.requests.Sessions.GmailSession;
import io.unity.framework.init.Session;
import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUpOtpTest extends base {

    @Test
    public void signup_with_valid_otp() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("signup/signup_with_valid_credentials");

        GmailSession session = new GmailSession();

        String final_otp = session.generate_otp();

        response.put("code", final_otp);


        ResponseValidator signup = new ResponseValidator(response);
        signup.statusCodeShouldBe(201);

        Map header = new HashMap();
        header.put("Content-Type","application/json");

        Map body = new HashMap();
        body.put("email","qabletest+1@gmail.com");
        body.put("code",final_otp);


        JSONObject otpResponse =    builder.performRequestWithHeaderAndBody("verifysignup/signup_with_valid_otp",header,body);

        System.out.println(otpResponse);
    }


}
