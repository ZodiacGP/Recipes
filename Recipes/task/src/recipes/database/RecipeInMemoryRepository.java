package recipes.database;

import org.springframework.stereotype.Repository;
import recipes.domain.Recipe;
import recipes.domain.RecipeRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class RecipeInMemoryRepository implements RecipeRepository {
	private Map<Integer, Recipe> recipes = new HashMap<>();

	@Override
	public Optional<Recipe> getRecipeById(int recipeId) {
		return Optional.ofNullable(recipes.get(recipeId));
	}

	@Override
	public void addRecipe(Recipe recipe) {
		recipes.put(recipe.getRecipeId().getId(), recipe);
	}
}
