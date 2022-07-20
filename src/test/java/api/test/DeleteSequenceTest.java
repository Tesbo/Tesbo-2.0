package api.test;

import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class DeleteSequenceTest extends base {


    @Test
    public void delete_sequence_with_valid_token() {
          RequestBuilder builder = new RequestBuilder();
//        Utility utils = new Utility();
//
//        JSONObject pathParameter = utils.getsequenceID();
//        JSONObject header = utils.login();
//        JSONObject body = new JSONObject();
//
//        String response = builder.updateRequestObject("sequence/delete_sequence/delete_sequence_with_valid_token", pathParameter, header, body);
//        JSONObject response1 = builder.performRequest(response);
//        System.out.println(response1);

      //  String response = builder.performRequest("sequence/delete_sequence/delete_sequence_with_valid_token");
        JSONObject response1 = builder.performRequest("sequence/delete_sequence/delete_sequence_with_valid_token");
    }
}
