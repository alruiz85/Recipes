package alruiz.es.recipepuppy.ui.main;


import alruiz.es.recipepuppy.domain.model.RecipeResponse;
import alruiz.es.recipepuppy.ui.base.BaseView;

/**
 * BaseView.
 *
 * @author AlfonsoRuiz
 */
public interface MainView extends BaseView {

    void showProgressBar();

    void hideProgressBar();

    void loadNewPage(int page);

    void populateRecipes(RecipeResponse response);

    void clearRecipes();

}
