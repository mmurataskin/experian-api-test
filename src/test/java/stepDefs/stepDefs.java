package stepDefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

public class stepDefs {
    Response response;

    @Given("existing Server application {string}")
    public void existing_Server_application_https_reqres_in_api(String url) {
       response =  RestAssured.given().contentType(ContentType.JSON).when().get(url);
    }


    @Then("on GET request to users it returns expected users list")
    public void on_GET_request_to_users_it_returns_expected_users_list() {
        response.getBody().prettyPrint();
    }


    @Then("on GET request it returns expected welcome message")
    public void on_GET_request_to_users_it_returns_expected_welcome_message() {
        response.getBody().prettyPrint();
        String expectedMessage = "To keep ReqRes free, contributions towards server costs are appreciated!";
        JsonPath jp = response.jsonPath();
        String actualMessage =  jp.get("support.text");
        Assert.assertEquals("Actual message is not matcing the expected message", expectedMessage, actualMessage);


    }


    @Then("on GET request it returns {string} status code")
    public void on_GET_request_to_users_it_returns_status_code(String statusCode) {
        response.getBody().prettyPrint();
        Assert.assertEquals(String.valueOf(response.statusCode()),statusCode);
    }
}
