package recipes.domain;

import java.util.Optional;

public interface RecipeRepository {
	Optional<Recipe> getRecipeById(int recipeId);

	void addRecipe(Recipe recipe);
}
