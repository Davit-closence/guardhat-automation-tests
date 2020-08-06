package rest_api;

import config.BaseApiConf;
import config.GeneralData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginAPI extends BaseApiConf {

    @Test
    public void login(){
      String s = String.valueOf(given()
                .header("Authorization",GeneralData.AUTHORIZATION)
                .contentType("multipart/form-data")
                .multiPart("client_id", GeneralData.CLIENT_ID)
                .multiPart("client_secret", GeneralData.CLIENT_SECRET)
                .multiPart("grant_type",GeneralData.GRANT_TYPE)
                .multiPart("username", GeneralData.USERNAME)
                .multiPart("password", GeneralData.PASSWORD)
                .when().post()
                .then());
    }
}
