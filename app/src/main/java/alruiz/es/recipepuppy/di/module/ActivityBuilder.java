package alruiz.es.recipepuppy.di.module;

import alruiz.es.recipepuppy.ui.main.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * ActivityBuilder.
 *
 * @author AlfonsoRuiz
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();

}
