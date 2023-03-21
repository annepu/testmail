package mailTravel.apis;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import mailTravel.framework.TestBase;

import static io.restassured.RestAssured.given;

public class ApiRequests extends TestBase {

    public String getApiResponse(String url) {
        RestAssured.baseURI = url;
        Response response = null;
        String responseBody = "";

        try {
            response = given()
                   // .contentType("application/json")
                    .when()
                    .get()
                    .then()
                    .extract()
                    .response();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null) {
            responseBody = response.getBody().asString();

            return responseBody;
        }
        return null;
    }

    public String postRequest(String url) {
        String baseUrl = url;
        Response response = null;
        String responseBody = "";
        RestAssured.baseURI = baseUrl;
        try {

            response = given()
                   // .header("Accept", ContentType.JSON.getAcceptHeader())
                    .queryParam("name", "testRandom")
                    .queryParam("salary", "34")
                    .queryParam("age", "45")
                    .when()
                    .post()
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null) {
            responseBody = response.asString();
            return responseBody;
        }
        return null;
    }

    public void updateRecord(String url, String userName, String authKey, String name, String status) {
        RestAssured.baseURI = url;
        given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("name", "test")
                .formParam("id", "9797")
                .formParam("salary","10000")
                .auth()
                .basic(userName, authKey)
                .when()
                .request()
                .put(url);
    }


}
