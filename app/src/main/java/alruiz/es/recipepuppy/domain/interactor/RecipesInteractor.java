package alruiz.es.recipepuppy.domain.interactor;

import alruiz.es.recipepuppy.domain.listeners.OnItemRetrievedListener;

/**
 * Recipes interactor.
 */
public interface RecipesInteractor {

    /**
     * Execute.
     * @param ingredients ingredients
     * @param query search query
     * @param page page
     * @param listener listener
     */
    void execute(final String ingredients, final String query, final int page,
                 final OnItemRetrievedListener listener);

}
