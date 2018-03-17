package alruiz.es.recipepuppy.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import alruiz.es.recipepuppy.data.repository.api.ApiSourceServer;
import alruiz.es.recipepuppy.domain.interactor.RecipesInteractor;
import alruiz.es.recipepuppy.domain.interactor.RecipesInteractorImpl;
import alruiz.es.recipepuppy.ui.main.adapter.RecipesAdapter;
import dagger.Module;
import dagger.Provides;

/**
 * Application module.
 *
 * @author AlfonsoRuiz
 */
@Module
public class ApplicationModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    RecipesInteractor providesRecipesInteractor(ApiSourceServer apiSourceServer) {
        return new RecipesInteractorImpl(apiSourceServer);
    }

    @Provides
    @Singleton
    RecipesAdapter providesRecipesAdapter(){
        return new RecipesAdapter();
    }

}
