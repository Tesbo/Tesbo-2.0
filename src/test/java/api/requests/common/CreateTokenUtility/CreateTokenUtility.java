package api.requests.common.CreateTokenUtility;

import api.requests.common.ExcelOperation.ExcelReader;
import io.unity.framework.init.base;
import java.io.File;
import java.util.*;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;

public class CreateTokenUtility extends base {


    public static void main(String[] args) {

            DataReader reader = new DataReader();
            RequestBuilder builder = new RequestBuilder();
            ExcelReader read_excel = new ExcelReader();

            List<String> userNameList = reader.getColumnData("Credential.xlsx", "Sheet1", "Username");
            List<String> passwordList = reader.getColumnData("Credential.xlsx", "Sheet1", "Password");

            String token = "";
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter your input: ");

            String test = in.nextLine();
            if (test.equals("yes")) {


                for (int i = 0; i < userNameList.size(); i++) {
                    for (int j = 0; j < passwordList.size(); j++) {

                        JSONObject queryParameter = new JSONObject();
                        JSONObject pathParameter = new JSONObject();
                        JSONObject header = new JSONObject();
                        header.put("content-type", "application/json");

                        JSONObject body = new JSONObject();
                        body.put("email", userNameList.get(i));
                        body.put("password", passwordList.get(j));
                        System.out.println(body);

                        try {


                            String response = builder.updateRequestObject("login/login_with_valid_credentials", pathParameter, queryParameter, header, body);
                            JSONObject response1 = builder.performRequest(response);

                            ResponseValidator validator = new ResponseValidator(response1);

                            token = "Bearer " + validator.getDataFromBody("$.payload.accessToken");
                        }
                        catch (Exception e){}

                        Map params = new HashMap();
                        params.put("Username", userNameList.get(i));
                        params.put("password", passwordList.get(j));
                        read_excel.writeIntoExcel(new File("src/test/java/data/Credential.xlsx"), "Sheet1", params, "Token", token);
                        i++;
                    }
                }

            } else {
                System.out.println("no changes in token");
            }
        }

    }


