package alruiz.es.recipepuppy.data.repository.api;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import alruiz.es.recipepuppy.R;
import alruiz.es.recipepuppy.data.model.RecipeResponseEntity;
import alruiz.es.recipepuppy.data.repository.mapper.RecipeResponseMapper;
import alruiz.es.recipepuppy.data.repository.service.RecipePuppyService;
import alruiz.es.recipepuppy.domain.listeners.OnItemRetrievedListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Comment.
 */
public class ApiSourceServer implements APISource {

    private RecipePuppyService service;
    private RecipeResponseMapper mapper;

    @Inject
    ApiSourceServer(RecipePuppyService service, RecipeResponseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public void getRecipes(final String ingredients, final String query, final int page,
                           final OnItemRetrievedListener listener) {
        Call<RecipeResponseEntity> call = service.getRecipes(ingredients, query, 1);
        call.enqueue(new Callback<RecipeResponseEntity>() {
            @Override
            public void onResponse(@NonNull Call<RecipeResponseEntity> call, @NonNull Response<RecipeResponseEntity> response) {
                listener.onSuccess(mapper.map(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<RecipeResponseEntity> call, @NonNull Throwable throwable) {
                listener.onError(R.string.error_server);
            }

        });
    }

}
