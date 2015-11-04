package thenextapp.dagger2wtf;

import thenextapp.dagger2wtf.ui.activities.MainActivity;
import thenextapp.dagger2wtf.ui.fragments.HomeFragment;

/**
 * Created by Sandy on 11/4/15.
 */
public interface DaggerGraph {
    void inject(MainActivity mainActivity);
    void inject(HomeFragment homeFragment);
}
