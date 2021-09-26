package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.domain.Recipe;
import recipes.domain.RecipeNotFoundException;
import recipes.domain.RecipeRepository;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository recipeRepository;

	public Recipe getRecipeById(int recipeId) {
		return recipeRepository.findById(recipeId).orElseThrow(RecipeNotFoundException::new);
	}

	public int save(Recipe recipe) {
		return recipeRepository.save(recipe).getId();
	}

	public void delete(int recipeId) {
		recipeRepository.delete(recipeRepository.findById(recipeId).orElseThrow(RecipeNotFoundException::new));
	}
}
