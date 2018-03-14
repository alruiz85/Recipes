package alruiz.es.recipepuppy.ui.main;

import javax.inject.Inject;

import alruiz.es.recipepuppy.ui.base.BasePresenter;


/**
 * BasePresenter.
 *
 * @author AlfonsoRuiz
 */
public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    MainPresenter(MainActivity activity) {
        super(activity);
    }

}
