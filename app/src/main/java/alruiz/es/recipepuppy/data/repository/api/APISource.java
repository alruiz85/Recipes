package alruiz.es.recipepuppy.data.repository.api;

/**
 * Comment.
 */

public interface APISource {

    void getRecipes(final String ingredients, final String query, final int page);

}