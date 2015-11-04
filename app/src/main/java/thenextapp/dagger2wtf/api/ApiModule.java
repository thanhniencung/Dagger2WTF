package thenextapp.dagger2wtf.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import thenextapp.dagger2wtf.config.ConfigModule;
import thenextapp.dagger2wtf.interfaces.Endpoint;

/**
 * Created by Sandy on 11/4/15.
 */

@Module (includes = ConfigModule.class)
public class ApiModule {
    @Provides
    @Singleton
    Retrofit provideRestAdapter(Endpoint endpoint) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(endpoint.getUrl())
                .build();
    }
}
