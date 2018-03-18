package alruiz.es.recipepuppy;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import alruiz.es.recipepuppy.di.component.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

/**
 * Application.
 */

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initLog();
        initDagger();
    }

    /**
     * Timber initialization.
     */
    private void initLog() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    /**
     * Dagger initialization build.
     */
    private void initDagger() {
        DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    /**
     * Activity injector.
     *
     * @return AndroidInjector<Activity>
     */
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}