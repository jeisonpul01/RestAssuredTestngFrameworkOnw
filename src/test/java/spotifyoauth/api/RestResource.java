package spotifyoauth.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import spotifyoauth.pojo.Playlist;

import java.util.HashMap;

public class RestResource {
    public static Response post(String endPoint, Object requestPlaylist) {
        return RestAssured.given(specBuilder.getRequestSpec())
                .body(requestPlaylist)
                .when()
                .post(endPoint)
                .then().spec(specBuilder.getResponseSpec())
                .extract()
                .response();
    }
    public static Response postAccount(HashMap<String,String> params){
        return RestAssured.given().
                baseUri("https://accounts.spotify.com").
                headers("Authorization", "Basic NDk5NmYyMmViZTVlNGRmYmJmN2RmODY4MTU4YmMzNWY6MjUxZWE5NzA3MDY5NGQzYWI5NGNkNWM5MTQ4NDY4MmI=",
                        "Content-Type", "application/x-www-form-urlencoded")
                .urlEncodingEnabled(true)
                .contentType(ContentType.URLENC)
                .formParams(params)
                .log().all()
                .when().post("/api/token")
                .then().spec(specBuilder.getResponseSpec())
                .extract()
                .response();
    }
    public static Response get (String endPointWithPlaylistId){
        return RestAssured.given(specBuilder.getRequestSpec()).
                when().get(endPointWithPlaylistId).
                then().spec(specBuilder.getResponseSpec()).
                log().all().
                extract().
                response();
    }
    public  static Response update (Object requestPlaysList, String endPointWithPlaylistId){
        return RestAssured.given(specBuilder.getRequestSpec())
                .body(requestPlaysList)
                .when().put(endPointWithPlaylistId)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200).
                extract()
                .response();
    }
}
