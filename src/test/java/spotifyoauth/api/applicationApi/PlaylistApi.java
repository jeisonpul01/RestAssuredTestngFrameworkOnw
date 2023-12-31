package spotifyoauth.api.applicationApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import spotifyoauth.api.RestResource;
import spotifyoauth.api.specBuilder;
import spotifyoauth.pojo.Playlist;

public class PlaylistApi {
    public static Response post(Playlist requestPlaylist) {
        return RestResource.post("/users/212d3gpw5zzc44pfqrkhlfeqi/playlists",  requestPlaylist);

    }
    public static Response get (){
        return RestResource.get("/playlists/3mxog5WmE3xRQDaMi4s400");

    }
    public  static Response update (Playlist requestPlaysList){
        return RestResource.update(requestPlaysList,"/playlists/3mxog5WmE3xRQDaMi4s400");

    }
}
