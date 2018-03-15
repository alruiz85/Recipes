package alruiz.es.recipepuppy.data.repository.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import alruiz.es.recipepuppy.data.model.RecipeResponse;
import alruiz.es.recipepuppy.data.repository.service.RecipePuppyService;
import okhttp3.ResponseBody;
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
        /*Call<List<RecipeResponse>> call = service.getRecipes("", "", 1);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //listener.onSuccess(null);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //listener.onError(R.string.error_gms_login_failure);
            }
        });*/
    }

}
