package alruiz.es.recipepuppy.domain.listeners;

import alruiz.es.recipepuppy.domain.model.RecipeResponse;

/**
 * Listener for items retrieved from server.
 */
public interface OnItemRetrievedListener {

    void onSuccess(RecipeResponse item);

    void onError(int errorId);

}
