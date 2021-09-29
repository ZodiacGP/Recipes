package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.domain.recipe.Recipe;
import recipes.domain.recipe.RecipeNotFoundException;
import recipes.dao.RecipeRepository;
import recipes.domain.user.ForbiddenException;

import java.util.List;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository recipeRepository;

	@Autowired
	UserService userService;


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
		recipe.setEmail(userService.getLoggedInUser());
		return recipeRepository.save(recipe).getId();
	}

	public void update(int recipeId, Recipe recipe) {
		Recipe recipeFromDB = recipeRepository.findById(recipeId).orElseThrow(RecipeNotFoundException::new);
		checkRights(recipeFromDB);
		recipeFromDB.copyOf(recipe);
		recipeRepository.save(recipeFromDB);
	}

	public void delete(int recipeId) {
		Recipe recipeFromDB = recipeRepository.findById(recipeId).orElseThrow(RecipeNotFoundException::new);
		checkRights(recipeFromDB);
		recipeRepository.delete(recipeFromDB);
	}

	private void checkRights(Recipe recipe) {
		if (!recipe.getEmail().equals(userService.getLoggedInUser())) {
			throw new ForbiddenException();
		}
	}
}
