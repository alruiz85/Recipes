package alruiz.es.recipepuppy.data.repository.mapper;

import javax.inject.Inject;

import alruiz.es.recipepuppy.data.model.RecipeResponseEntity;
import alruiz.es.recipepuppy.domain.model.RecipeResponse;

/**
 * Map RecipeResponse.
 */
public class RecipeResponseMapper extends BaseMapper<RecipeResponseEntity, RecipeResponse> {

    private RecipeMapper recipeMapper;

    @Inject
    RecipeResponseMapper(RecipeMapper recipeMapper) {
        this.recipeMapper = recipeMapper;
    }

    @Override
    public RecipeResponse map(RecipeResponseEntity recipeResponseEntity) {
        if (recipeResponseEntity == null) return null;
        return new RecipeResponse(
                recipeResponseEntity.getTitle(),
                recipeResponseEntity.getVersion(),
                recipeResponseEntity.getHref(),
                recipeMapper.map(recipeResponseEntity.getResults())
        );
    }

}
