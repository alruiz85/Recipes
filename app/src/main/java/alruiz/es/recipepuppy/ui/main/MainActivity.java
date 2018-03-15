package alruiz.es.recipepuppy.ui.main;

import android.os.Bundle;

import javax.inject.Inject;

import alruiz.es.recipepuppy.R;
import alruiz.es.recipepuppy.ui.base.BaseActivity;
import dagger.android.AndroidInjection;

/**
 * MainActivity.
 *
 * @author AlfonsoRuiz
 */
public class MainActivity extends BaseActivity implements MainView {

    private static String TAG = "MainActivity";

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter.getRecipesFromServer();
    }

    @Override
    public void showError(int errorId) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void getRecipes() {

    }

    @Override
    public void populateRecipes() {

    }
}
