package apiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class Tests {

    @Test
    public void test1() {
        Response response = given()
                .header("Content-Type", "application/json")
                .get("https://apteka.103.by/api/v2/pharmacy/26837228/?sku_id=39432");

        response.then()
                .assertThat()
                .statusCode(200);

        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("data.id"), 26837228);
    }

    @Test
    public void test2() {
        Response response = given()
                .header("Content-Type", "application/json")
                .get("https://apteka.103.by/api/v2/pharmacy/26837228/?sku_id=39432");

        response.then()
                .assertThat()
                .statusCode(200);

        response.then().assertThat().body(matchesJsonSchema(getJson("forTest1")));
    }

    @Test
    public void test3() {
        Response response = given()
                .header("Content-Type", "application/json")
                .get("https://www.103.by/auth/userinfo/");

        response.then()
                .assertThat()
                .statusCode(200);

        Assert.assertFalse(response.then().extract().response().jsonPath().getBoolean("authorized"));
    }

    @Test
    public void test4() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body(getJson("forPost"))
                .post("https://restful-booker.herokuapp.com/auth");

        response.then().assertThat().statusCode(200);

        String tokenForAuth = response.then().extract().response().jsonPath().getString("token");

        System.out.println(tokenForAuth);
    }

    public String getJson(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("files/" + fileName + ".json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
