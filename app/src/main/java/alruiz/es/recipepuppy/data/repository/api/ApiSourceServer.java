package alruiz.es.recipepuppy.data.repository.api;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import alruiz.es.recipepuppy.data.model.RecipeResponseEntity;
import alruiz.es.recipepuppy.data.repository.service.RecipePuppyService;
import alruiz.es.recipepuppy.domain.listeners.OnItemRetrievedListener;
import alruiz.es.recipepuppy.domain.model.Recipe;
import alruiz.es.recipepuppy.domain.model.RecipeResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Comment.
 */
public class ApiSourceServer implements APISource {

    private RecipePuppyService service;

    @Inject
    ApiSourceServer(RecipePuppyService service) {
        this.service = service;
    }

    @Override
    public void getRecipes(final String ingredients, final String query, final int page,
                           final OnItemRetrievedListener listener) {
        Call<RecipeResponseEntity> call = service.getRecipes(ingredients, query, 1);
        call.enqueue(new Callback<RecipeResponseEntity>() {
            @Override
            public void onResponse(@NonNull Call<RecipeResponseEntity> call, @NonNull Response<RecipeResponseEntity> response) {
                //TODO Mapper bueno
                //RecipeResponseEntity r = response.body();
                //RecipeResponse recipeResponse = new RecipeResponse(r.getTitle(), r.getVersion(), r.getHref(), (Recipe)r.getResults());
                //listener.onSuccess(recipeResponse);
            }

            @Override
            public void onFailure(@NonNull Call<RecipeResponseEntity> call, @NonNull Throwable throwable) {
                //TODO
            }

        });
    }

}
