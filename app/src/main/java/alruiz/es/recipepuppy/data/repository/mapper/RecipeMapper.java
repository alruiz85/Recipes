package alruiz.es.recipepuppy.data.repository.mapper;

import javax.inject.Inject;

import alruiz.es.recipepuppy.data.model.RecipeEntity;
import alruiz.es.recipepuppy.domain.model.Recipe;

/**
 * Map response.
 */
public class RecipeMapper extends BaseMapper<RecipeEntity, Recipe> {

    @Inject
    RecipeMapper() {
    }

    @Override
    public Recipe map(RecipeEntity recipeEntity) {
        if (recipeEntity == null) return null;
        return new Recipe(
                recipeEntity.getTitle(),
                recipeEntity.getHref(),
                recipeEntity.getIngredients(),
                recipeEntity.getThumbnail());
    }

}
