package alruiz.es.recipepuppy.di.component;

import javax.inject.Singleton;

import alruiz.es.recipepuppy.App;
import alruiz.es.recipepuppy.di.module.ActivityBuilder;
import alruiz.es.recipepuppy.di.module.ApplicationModule;
import alruiz.es.recipepuppy.di.module.NetModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Application component.
 *
 * @author AlfonsoRuiz
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        ApplicationModule.class,
        NetModule.class})
public interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App app);

        ApplicationComponent build();
    }

    void inject(App app);

}
