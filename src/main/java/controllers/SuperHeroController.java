package controllers;

import dto.Superhero;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseApi;
import static io.restassured.RestAssured.given;

public class SuperHeroController implements BaseApi {
    public Response createSuperHero(Superhero hero){
        return given()
                .body(hero)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL+POST_URL)
                .thenReturn();

    }

    public Response getAllSuperHeroes(){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL+POST_URL)
                .thenReturn();
    }

    public Response getSuperHeroById(String id){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL+POST_URL+"/"+id)
                .thenReturn();
    }

    public Response deleteSuperHeroById(String id){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .delete(BASE_URL+POST_URL+"/"+id)
                .thenReturn();
    }
}
