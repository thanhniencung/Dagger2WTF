package thenextapp.dagger2wtf;

import android.app.Application;

/**
 * Created by Sandy on 11/4/15.
 */
public class GithubApplication extends Application {

    private static DaggerGraph graph;
    private static GithubApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        buildComponentAndInject();
    }

    public static DaggerGraph component() {
        return graph;
    }

    public static void buildComponentAndInject() {
        graph = ApplicationComponent.Initializer.init(app);
    }
}
