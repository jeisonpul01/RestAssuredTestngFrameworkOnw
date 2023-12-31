package spotifyoauth.tests;


import io.restassured.response.Response;

import org.testng.annotations.Test;
import spotifyoauth.api.applicationApi.PlaylistApi;
import spotifyoauth.pojo.Playlist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PlaylistTest {


    @Test
    public void createPlayList() {
        Playlist requestPlaylist = new Playlist().
                setName("New Playlist 3").
                setDescription("is not your business").
                setPublic(true);

        Response response = PlaylistApi.post(requestPlaylist);
        assertThat(response.statusCode(), equalTo(201));

        Playlist responsePlaylist= response.as(Playlist.class);

        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.getPublic(), equalTo(requestPlaylist.getPublic()));


    }

    @Test
    public void getPlaylist() {


        Response response= PlaylistApi.get();
        assertThat(response.statusCode(), equalTo(200));

        Playlist responsePlaylist= response.as(Playlist.class);


        assertThat(responsePlaylist.getName(), equalTo("Random Updated"));
        assertThat(responsePlaylist.getDescription(), equalTo("another playlist description"));
        assertThat(responsePlaylist.getPublic(), equalTo(true));

    }

    @Test
    public void UpdatePlaylist() {
        String playlistId= "3mxog5WmE3xRQDaMi4s400";
        Playlist requestPlaysList = new Playlist()
                .setName("Random Updated")
                .setDescription("another playlist description")
                .setPublic(true);

        Response response= PlaylistApi.update(requestPlaysList );
        assertThat(response.statusCode(), equalTo(200));
    }



}

































