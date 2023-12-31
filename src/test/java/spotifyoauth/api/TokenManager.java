package spotifyoauth.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenManager {
    private static String accessToken;
    private static Instant expiry_time;
    public synchronized static String getToken(){
        try{
            if (accessToken== null || Instant.now().isAfter(expiry_time)){
                System.out.println("Renewing token...");
                Response response= RefreshToken();
                accessToken = "Bearer " + response.path("access_token");
                int expiryDurationInSeconds = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds - 300);
            } else {
                System.out.println("Token is good to use");

            }

        }
            catch (Exception e){
                    throw  new RuntimeException("ABORT!!! Failed to get token");
            }
        return accessToken;
    }



    private static Response RefreshToken(){
        HashMap<String, String> params = new HashMap<>();
        params.put("grant_type", "refresh_token");
        params.put("refresh_token", "AQDGRv6ZIV5LtyLkXWkKB0pKN09CXlxPk6QEgLejEbUsTPtlIWG9MNisd-Vu_rqneJBaBF6V4Rzw5lofkxgrTnIDFuw0nirq6rdd0KO-dCKIgPTokZnz8xVF6TZuZos-9Ug");
        params.put("client_id", "4996f22ebe5e4dfbbf7df868158bc35f");

        Response response= RestResource.postAccount(params);
        String accessToken = "Bearer " + response.path("access_token");

        if (response.statusCode() !=200){
            throw  new RuntimeException("Abort!! renew token failed");
        }

        return response;






    }
}




























