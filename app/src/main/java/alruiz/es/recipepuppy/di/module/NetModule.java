package alruiz.es.recipepuppy.di.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import alruiz.es.recipepuppy.BuildConfig;
import alruiz.es.recipepuppy.data.repository.service.RecipePuppyService;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Network module.
 *
 * @author AlfonsoRuiz
 */
@Module
public class NetModule {

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient().newBuilder().build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.RECIPEPUPPY_ENDPOINT)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public RecipePuppyService provideRecipePuppyService(Retrofit retrofit) {
        return retrofit.create(RecipePuppyService.class);
    }


}
