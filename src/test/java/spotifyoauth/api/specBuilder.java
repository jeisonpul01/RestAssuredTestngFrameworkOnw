package spotifyoauth.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class specBuilder {
    static String access_token = "BQDZ4MR-7gChu8SpJQmPU-cBCuMLhT5VD0vMQRS3FaZGinp1Pquv2M_GNIlOl6DhaFRJOo7-rJNRpMiVQhnV9brqVE78pbb8u2GRXDrIIpTa7mBYhwu_5U6SxIAALh7rs6uTgGgG4lblDXaTyDV57bQNOS_FwB7vEKoHvUfZ56R9JcxU6Io3bPosR28sYT0tVEqYMVy_rAmodgC55SGoQleTjzzrSqhmdqjDK-ZjIQR8kvTku1PxWl_MG-G9SpnVX3XvPI2j5eg_";


    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri("https://api.spotify.com").
                setBasePath("/v1").
                addHeader("Authorization",TokenManager.getToken()).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();




    }
    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL).build();



    }
}
