package com.step;

import model.mapper.PetStoreMapper;
import model.model.ApiResponse;
import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.assertj.core.api.Assertions;

@Slf4j
public class StepImpl {

    private final static java.lang.String Base_Url = "https://petstore.swagger.io/v2";
    private final static String post_path = "/pet";
    private final static String put_path = "/pet";
    private final static String get_path = "/pet/";
    private final static String delete_path = "/pet/";


    public StepImpl() {
        log.info("StepImpl constructor");
    }


    @Step("Post Request : PetId: <id> ve name: <name>")
    public ApiResponse post(String id, String name) {
        var request = PetStoreMapper.requestToAvailRQ(id, name);
        var response = RestAssured.given().baseUri(Base_Url)
                .body(request)
                .contentType(ContentType.JSON)
                .post(post_path)
                .then()
                .statusCode(200)
                .extract().as(ApiResponse.class);

        System.out.println("Post PetId : " + response.getId());
        System.out.println("Post Name : " + response.getName());
        Assertions.assertThat(response.getId()).isEqualTo(Integer.parseInt(id));
        Assertions.assertThat(response.getName()).isEqualTo(name);
        System.out.println("****************");

        return response;
    }

    @Step("Get Request  : PetId: <id>")
    public ApiResponse get(String id) {
        var response = RestAssured.given().baseUri(Base_Url)
                .contentType(ContentType.JSON)
                .get(get_path + id)
                .then()
                .statusCode(200)
                .extract().as(ApiResponse.class);

        System.out.println("Get PetId : " + response.getId());
        System.out.println("Get Name : " + response.getName());
        Assertions.assertThat(response.getId()).isEqualTo(Integer.parseInt(id));
        System.out.println("****************");

        return response;
    }

    @Step("Put Request  : PetId: <id> ve name: <bobo>")
    public ApiResponse put(String id, String name) {
        var request = PetStoreMapper.requestToAvailRQ(id, name);
        var response = RestAssured.given().baseUri(Base_Url)
                .body(request)
                .contentType(ContentType.JSON)
                .put(put_path)
                .then()
                .statusCode(200)
                .extract().as(ApiResponse.class);

        System.out.println("Put PetId : " + response.getId());
        System.out.println("Put Name : " + response.getName());
        Assertions.assertThat(response.getId()).isEqualTo(Integer.parseInt(id));
        Assertions.assertThat(response.getName()).isEqualTo(name);
        System.out.println("****************");
        return response;

    }

    @Step("Delete Request  : PetId: <id>")
     public ApiResponse delete(String id) {
        var response = RestAssured.given().baseUri(Base_Url)
                .contentType(ContentType.JSON)
                .delete(delete_path + id)
                .then()
                .statusCode(200)
                .extract().as(ApiResponse.class);

        System.out.println("Delete PetId : " + response.getId());
        System.out.println("PetId not found");
        Assertions.assertThat(response.getId()).isNotEqualTo(Integer.parseInt(id));
        System.out.println("****************");

        return response;

    }
}