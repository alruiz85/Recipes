package alruiz.es.recipepuppy.ui.main;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ProgressBar;

import javax.inject.Inject;

import alruiz.es.recipepuppy.R;
import alruiz.es.recipepuppy.domain.model.RecipeResponse;
import alruiz.es.recipepuppy.ui.base.BaseActivity;
import alruiz.es.recipepuppy.ui.main.adapter.RecipesAdapter;
import butterknife.BindView;
import butterknife.OnTextChanged;
import dagger.android.AndroidInjection;
import timber.log.Timber;

/**
 * MainActivity.
 *
 * @author AlfonsoRuiz
 */
public class MainActivity extends BaseActivity implements MainView {

    private static String TAG = "MainActivity: ";
    private static final int FIRST_PAGE = 1;

    @BindView(R.id.recycler_main)
    RecyclerView rvRecipes;
    @BindView(R.id.pb_main)
    ProgressBar progressBar;

    private String query = "";

    @Inject
    MainPresenter mainPresenter;
    @Inject
    RecipesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecipesAdapter();
    }

    private void initRecipesAdapter() {
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, GridLayout.VERTICAL);
        rvRecipes.setAdapter(adapter);
        rvRecipes.addItemDecoration(itemDecor);
        rvRecipes.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnTextChanged(R.id.et_search)
    void onSearch(CharSequence sequence, int start, int count, int after) {
        Timber.d("%s%s", TAG, sequence);

        query = sequence.toString();
        mainPresenter.getRecipesFromServer(query, FIRST_PAGE);
    }

    @Override
    public void showError(int errorId) {

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void loadNewPage(int page) {
        mainPresenter.getRecipesFromServer(query, page);
    }

    @Override
    public void populateRecipes(RecipeResponse response) {
        adapter.setItems(response.getResults());
    }

    @Override
    public void clearRecipes() {
        adapter.clearItems();
    }

}
