package alruiz.es.recipepuppy.data.repository.mapper;

import alruiz.es.recipepuppy.data.model.RecipeResponse;
import alruiz.es.recipepuppy.domain.model.Recipe;

/**
 * RecipeMapper.
 */

public class RecipeMapper extends BaseMapper<Recipe, RecipeResponse> {


    @Override
    public RecipeResponse map(Recipe value) {
        return null;
    }

    @Override
    public Recipe reverseMap(RecipeResponse value) {
        return null;
    }
}
