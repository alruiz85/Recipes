package alruiz.es.recipepuppy.ui.main;

import javax.inject.Inject;

import alruiz.es.recipepuppy.domain.interactor.RecipesInteractor;
import alruiz.es.recipepuppy.domain.listeners.OnItemRetrievedListener;
import alruiz.es.recipepuppy.domain.model.RecipeResponse;
import alruiz.es.recipepuppy.ui.base.BasePresenter;
import timber.log.Timber;


/**
 * Main presenter.
 *
 * @author AlfonsoRuiz
 */
public class MainPresenter extends BasePresenter<MainView> {

    private final String TAG = "MainPresenter: ";
    private final String INGREDIENTS = "";

    private RecipesInteractor interactor;

    private String lastQuery;

    @Inject
    MainPresenter(MainActivity activity, RecipesInteractor interactor) {
        super(activity);
        this.interactor = interactor;
    }

    /**
     * Receives and execute query.
     *
     * @param query query
     * @param page  current page
     */
    void getRecipesFromServer(final String query, final int page) {
        Timber.d("%s Query: %s - Page: %s", TAG, lastQuery, page);

        lastQuery = query;
        if (lastQuery.length() > 0) {
            getView().hideStatusMessage();
            getView().showProgressBar();

            interactor.execute(INGREDIENTS, lastQuery, page, new OnItemRetrievedListener() {

                @Override
                public void onSuccess(RecipeResponse response) {
                    if (response == null || lastQuery.length() == 0 || response.getResults().size() == 0) {
                        getView().showStatusMessage();
                    } else if (response.getResults().size() > 0) {
                        Timber.d("%s %s", TAG, response.toString());
                        getView().populateRecipes(response);
                    }
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
        }
    }

    /**
     * Clear recipes from recycler view.
     */
    void clearRecipes() {
        getView().clearRecipes();
    }

    /**
     * Show status messages, no recipes.
     */
    void showStatusMessage() {
        getView().showStatusMessage();
    }

}
