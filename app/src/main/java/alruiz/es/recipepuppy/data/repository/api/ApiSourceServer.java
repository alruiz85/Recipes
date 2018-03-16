package alruiz.es.recipepuppy.data.repository.api;

import javax.inject.Inject;

import alruiz.es.recipepuppy.data.model.RecipeResponse;
import alruiz.es.recipepuppy.data.repository.service.RecipePuppyService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Comment.
 */

public class ApiSourceServer implements APISource {

    private RecipePuppyService service;

    @Inject
    public ApiSourceServer(RecipePuppyService service) {
        this.service = service;
    }

    @Override
    public void getRecipes(final String ingredients, final String query, final int page) {
        Call<RecipeResponse> call = service.getRecipes("", "", 1);
        call.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                int i = 0;
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                int i = 0;
            }

        });
    }

}
