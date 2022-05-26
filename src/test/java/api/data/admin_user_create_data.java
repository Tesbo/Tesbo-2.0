package api.data;



import io.unity.framework.data.TestData;

import java.util.HashMap;
import java.util.Map;

public class admin_user_create_data {


    public Map generateValidUserBodyData() {
        Map body = new HashMap();
        body.put("firstName", TestData.first_name());
        body.put("lastName", TestData.last_name());
        body.put("email", TestData.email());
        body.put("password", "QAble@1010");
        body.put("phone", "8128988148");
        body.put("code", "91");
        return body;
    }


}
