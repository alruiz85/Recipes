package alruiz.es.recipepuppy.data.repository.service;

import alruiz.es.recipepuppy.data.model.RecipeResponseEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * WebServices interfaces.
 */

public interface RecipePuppyService {

    @GET("./")
    Call<RecipeResponseEntity> getRecipes(@Query("i") String ingredient,
                                          @Query("q") String query,
                                          @Query("p") int page);

}
