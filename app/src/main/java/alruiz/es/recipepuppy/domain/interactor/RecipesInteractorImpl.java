package alruiz.es.recipepuppy.domain.interactor;

import alruiz.es.recipepuppy.data.repository.api.ApiSourceServer;
import alruiz.es.recipepuppy.domain.listeners.OnItemRetrievedListener;

/**
 * Interactor implementation.
 */

public class RecipesInteractorImpl implements RecipesInteractor {

    private ApiSourceServer sourceServer;

    public RecipesInteractorImpl(ApiSourceServer sourceServer) {
        this.sourceServer = sourceServer;
    }

    @Override
    public void execute(final String ingredients, final String query, final int page,
                        OnItemRetrievedListener listener) {
        sourceServer.getRecipes(ingredients, query, page, listener);
    }

}
