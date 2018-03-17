package alruiz.es.recipepuppy.data.repository.api;

import alruiz.es.recipepuppy.domain.listeners.OnItemRetrievedListener;

/**
 * Comment.
 */

public interface APISource {

    void getRecipes(final String ingredients, final String query, final int page,
                    final OnItemRetrievedListener listener);

}