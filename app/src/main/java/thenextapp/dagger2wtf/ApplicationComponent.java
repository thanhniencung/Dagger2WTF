package thenextapp.dagger2wtf;

import javax.inject.Singleton;

import dagger.Component;
import thenextapp.dagger2wtf.api.ApiModule;

/**
 * Created by Sandy on 11/4/15.
 */

@Singleton
@Component (
        modules = {
                ApplicationModule.class,
                ApiModule.class
        }
)
public interface ApplicationComponent extends DaggerGraph{
    static final class Initializer {
        public Initializer() {}

        public static ApplicationComponent init(GithubApplication app) {
            return DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(app))
                    .build();
        }
    }
}
