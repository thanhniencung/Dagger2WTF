package thenextapp.dagger2wtf.config;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;
import thenextapp.dagger2wtf.api.FixedEndpoint;
import thenextapp.dagger2wtf.api.GithubApi;
import thenextapp.dagger2wtf.constant.Constant;
import thenextapp.dagger2wtf.interfaces.Endpoint;

/**
 * Created by Sandy on 11/4/15.
 */

@Module
public class ConfigModule {

    @Provides
    @Singleton
    Endpoint provideEndpoint() {
        return new FixedEndpoint(Constant.API_ROOT_URL, Constant.API_GET_ALL_REPOSITORY);
    }

    @Provides
    @Singleton
    GithubApi provideGithubApi(Retrofit retrofit) {
        return retrofit.create(GithubApi.class);
    }

}
