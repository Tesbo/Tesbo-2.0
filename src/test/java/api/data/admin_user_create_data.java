package api.data;

import io.unity.autoweb.random.random_data;

import java.util.HashMap;
import java.util.Map;

public class admin_user_create_data {


    public Map generateValidUserBodyData() {
        Map body = new HashMap();
        body.put("firstName", random_data.first_name());
        body.put("lastName", random_data.last_name());
        body.put("email", random_data.email());
        body.put("password", "QAble@1010");
        body.put("phone", "8128988148");
        body.put("code", "91");
        return body;
    }


}
