package twit;

import dagger.Provides;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface TwitApi {



    @GET("games/top")
    Call<Twit> getTopGames(@Header("Client-Id") String ClientId);

}
