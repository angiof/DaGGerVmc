package twit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

@Module
public class TwitModule {

    public final String BASE_URL = "https://api.twitch.tv/helix/";

    @Provides
    public OkHttpClient providerHttpClient() {
        //1impostiamo il login interceptor per controllare le chiamate api rest
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // 2settiamo il livello
        //ricuperiamo il okclient
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }
        @Provides
    public Retrofit providerRetroFit(String baseUrl, OkHttpClient client) {
        //isntanzia di retorfit o motore
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    @Provides
    public TwitApi ProviderApi() {
        //impostazioni delle chiamate
        //2intanziamo il motore di retro injectiamo l'url ,intanziamo il client
        //in modo che possa registrare ed effettuare tutte le chiamate impostate nella classe api
        return providerRetroFit(BASE_URL, providerHttpClient()).create(TwitApi.class);
    }

}
