package alruiz.es.recipepuppy.ui.main;

import javax.inject.Inject;

import alruiz.es.recipepuppy.domain.interactor.RecipesInteractor;
import alruiz.es.recipepuppy.ui.base.BasePresenter;


/**
 * BasePresenter.
 *
 * @author AlfonsoRuiz
 */
public class MainPresenter extends BasePresenter<MainView> {

    RecipesInteractor interactor;

    @Inject
    MainPresenter(MainActivity activity, RecipesInteractor interactor) {
        super(activity);
        this.interactor = interactor;
    }

    public void getRecipesFromServer(){
        interactor.execute("", "", 1);
    }

}
