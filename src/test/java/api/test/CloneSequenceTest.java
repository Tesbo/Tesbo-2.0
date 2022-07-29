package api.test;

import api.requests.common.Utility;
import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CloneSequenceTest extends base {
    @Test
    public void clone_sequence_with_valid_token() {
        RequestBuilder builder = new RequestBuilder();
        Utility utils = new Utility();

        JSONObject pathParameter = utils.getsequenceID();
        JSONObject header = utils.login();
        JSONObject body = new JSONObject();
        JSONObject queryParameter = new JSONObject();

        String response2 = builder.updateRequestObject("sequence/clone_sequence/clone_sequence_with_valid_token", pathParameter,queryParameter, header, body);
        JSONObject response3 = builder.performRequest(response2);

        ResponseValidator validator = new ResponseValidator(response3);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Sequence duplicated successfully");

    }

    @Test
    public void clone_sequence_with_blank_token() {
        RequestBuilder builder = new RequestBuilder();
        Utility utils = new Utility();

        JSONObject pathParameter = utils.getsequenceID();
        JSONObject header = new JSONObject();
        header.put("Authorization", "");
        JSONObject body = new JSONObject();
        JSONObject queryParameter = new JSONObject();

        String response2 = builder.updateRequestObject("sequence/clone_sequence/clone_sequence_with_blank_token", pathParameter,queryParameter, header, body);
        JSONObject response3 = builder.performRequest(response2);

        ResponseValidator validator = new ResponseValidator(response3);
        validator.statusCodeShouldBe(400);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Invalid token");
    }

    @Test
    public void clone_sequence_with_invalid_token() {
        RequestBuilder builder = new RequestBuilder();
        Utility utils = new Utility();

        JSONObject pathParameter = utils.getsequenceID();
        JSONObject header = new JSONObject();
        JSONObject body = new JSONObject();
        JSONObject queryParameter = new JSONObject();

        String response2 = builder.updateRequestObject("sequence/clone_sequence/clone_sequence_with_invalid_token", pathParameter,queryParameter, header, body);
        JSONObject response3 = builder.performRequest(response2);

        ResponseValidator validator = new ResponseValidator(response3);
        validator.statusCodeShouldBe(400);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Invalid token");
    }

    @Test
    public void clone_sequence_with_another_user_token() {
        RequestBuilder builder = new RequestBuilder();
        Utility utils = new Utility();

        JSONObject pathParameter = utils.getsequenceID();
        JSONObject header = new JSONObject();
        JSONObject body = new JSONObject();
        JSONObject queryParameter = new JSONObject();

        String response2 = builder.updateRequestObject("sequence/clone_sequence/clone_sequence_with_another_user_token", pathParameter,queryParameter, header, body);
        JSONObject response3 = builder.performRequest(response2);

        ResponseValidator validator = new ResponseValidator(response3);
        validator.statusCodeShouldBe(400);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Invalid token");
    }

    @Test
    public void clone_sequence_with_post_method() {
        RequestBuilder builder = new RequestBuilder();
        Utility utils = new Utility();

        JSONObject pathParameter = utils.getsequenceID();
        JSONObject header = utils.login();
        JSONObject body = new JSONObject();
        JSONObject queryParameter = new JSONObject();

        String response2 = builder.updateRequestObject("sequence/clone_sequence/clone_sequence_with_post_method", pathParameter,queryParameter, header, body);
        JSONObject response3 = builder.performRequest(response2);
    }

    @Test
    public void clone_sequence_with_another_user_content_type() {
        RequestBuilder builder = new RequestBuilder();
        Utility utils = new Utility();

        JSONObject pathParameter = utils.getsequenceID();
        JSONObject header = utils.diffcontenttypelogin();
        JSONObject body = new JSONObject();
        JSONObject queryParameter = new JSONObject();

        String response2 = builder.updateRequestObject("sequence/clone_sequence/clone_sequence_with_valid_token", pathParameter,queryParameter, header, body);
        JSONObject response3 = builder.performRequest(response2);
    }

    @Test
    public void clone_sequence_with_blank_sequenceid() {
        RequestBuilder builder = new RequestBuilder();
        Utility utils = new Utility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId","");
        JSONObject header = utils.login();
        JSONObject body = new JSONObject();
        JSONObject queryParameter = new JSONObject();

        String response2 = builder.updateRequestObject("sequence/clone_sequence/clone_sequence_with_blank_sequenceid", pathParameter,queryParameter, header, body);
        JSONObject response3 = builder.performRequest(response2);
}
    @Test
    public void clone_sequence_with_invalid_sequenceid() {
        RequestBuilder builder = new RequestBuilder();
        Utility utils = new Utility();

        JSONObject pathParameter = new JSONObject();
        pathParameter.put("sequenceId","test");
        JSONObject header = utils.login();
        JSONObject body = new JSONObject();
        JSONObject queryParameter = new JSONObject();

        String response2 = builder.updateRequestObject("sequence/clone_sequence/clone_sequence_with_blank_sequenceid", pathParameter,queryParameter, header, body);
        JSONObject response3 = builder.performRequest(response2);
    }

    @Test
    public void clone_sequence_with_same_sequenceid() {
        RequestBuilder builder = new RequestBuilder();
        Utility utils = new Utility();

        JSONObject pathParameter = utils.clonesequenceID();
        JSONObject header = utils.login();
        JSONObject body = new JSONObject();
        JSONObject queryParameter = new JSONObject();

        String response2 = builder.updateRequestObject("sequence/clone_sequence/clone_sequence_with_valid_token", pathParameter,queryParameter, header, body);
        JSONObject response3 = builder.performRequest(response2);
    }
}