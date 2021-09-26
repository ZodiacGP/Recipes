package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import recipes.domain.Recipe;
import recipes.domain.RecipeRepository;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository recipeRepository;

	public Recipe getRecipeById(int recipeId) {
		return recipeRepository.getRecipeById(recipeId);
	}

	public void save(Recipe recipe) {
		recipeRepository.save(recipe);
	}

	public void delete(int recipeId) {
		recipeRepository.delete(recipeRepository.getRecipeById(recipeId));
	}

	public HttpStatus getResponseStatus(Recipe recipe) {
		if (recipe == null) {
			return HttpStatus.NOT_FOUND;
		}
		if (isEmpty(recipe)) {
			return HttpStatus.BAD_REQUEST;
		}
		return HttpStatus.OK;
	}

	private boolean isEmpty(Recipe recipe) {
		return recipe.getDescription() == null ||
				recipe.getDescription().trim().isEmpty() ||
				recipe.getName() == null ||
				recipe.getName().trim().isEmpty() ||
				recipe.getDirections() == null ||
				recipe.getDirections().isEmpty() ||
				recipe.getIngredients() == null ||
				recipe.getIngredients().isEmpty();
	}
}
