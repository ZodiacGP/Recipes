package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.domain.Recipe;
import recipes.domain.RecipeNotFoundException;
import recipes.domain.RecipeRepository;

import java.util.List;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository recipeRepository;

	public Recipe getRecipeById(int recipeId) {
		return recipeRepository.findById(recipeId).orElseThrow(RecipeNotFoundException::new);
	}

	public List<Recipe> getRecipeByName(String name) {
		return recipeRepository.findAllByNameContainingIgnoreCaseOrderByDateDesc(name);
	}

	public List<Recipe> getRecipeByCategory(String category) {
		return recipeRepository.findAllByCategoryIgnoreCaseEqualsOrderByDateDesc(category);
	}

	public int save(Recipe recipe) {
		return recipeRepository.save(recipe).getId();
	}

	public void update(int recipeId, Recipe recipe) {
		Recipe recipeFromDB = recipeRepository.findById(recipeId).orElseThrow(RecipeNotFoundException::new);
		recipeFromDB.copyOf(recipe);
		recipeRepository.save(recipeFromDB);
	}

	public void delete(int recipeId) {
		recipeRepository.delete(recipeRepository.findById(recipeId).orElseThrow(RecipeNotFoundException::new));
	}
}
