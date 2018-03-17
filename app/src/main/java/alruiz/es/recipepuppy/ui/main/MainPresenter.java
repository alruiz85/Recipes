package alruiz.es.recipepuppy.ui.main;

import javax.inject.Inject;

import alruiz.es.recipepuppy.domain.interactor.RecipesInteractor;
import alruiz.es.recipepuppy.domain.listeners.OnItemRetrievedListener;
import alruiz.es.recipepuppy.domain.model.RecipeResponse;
import alruiz.es.recipepuppy.ui.base.BasePresenter;


/**
 * Main presenter.
 *
 * @author AlfonsoRuiz
 */
public class MainPresenter extends BasePresenter<MainView> {

    private RecipesInteractor interactor;

    @Inject
    MainPresenter(MainActivity activity, RecipesInteractor interactor) {
        super(activity);
        this.interactor = interactor;
    }

    void getRecipesFromServer(final String query, final int page) {
        if (query.length() > 0) {
            getView().hideStatusMessage();
            getView().showProgressBar();
            getView().clearRecipes();

            interactor.execute("", query, page, new OnItemRetrievedListener() {

                @Override
                public void onSuccess(RecipeResponse response) {
                    getView().populateRecipes(response);
                    getView().hideProgressBar();
                }

                @Override
                public void onError(int errorId) {
                    getView().showError(errorId);
                    getView().clearRecipes();
                    getView().hideProgressBar();
                    getView().showStatusMessage();
                }
            });
        } else {
            getView().clearRecipes();
            getView().showStatusMessage();
        }
    }

}
