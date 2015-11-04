package thenextapp.dagger2wtf;

import android.app.Application;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Sandy on 11/4/15.
 */

@Module
public class ApplicationModule {

    private final GithubApplication app;

    public ApplicationModule(GithubApplication application) {
        app = application;
    }

    @Provides
    @Singleton
    protected Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    protected Resources provideResources() {
        return app.getResources();
    }
}
