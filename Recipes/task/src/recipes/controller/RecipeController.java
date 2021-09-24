package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.domain.Recipe;
import recipes.domain.RecipeRepository;

import java.util.Optional;

@RestController
public class RecipeController {

	@Autowired
	RecipeRepository recipeRepository;

	@GetMapping("/api/recipe/{id}")
	public ResponseEntity<?> getRecipe(@PathVariable int id) {
		Optional<Recipe> recipeOptional = recipeRepository.getRecipeById(id);
		return recipeOptional.isPresent() ? ResponseEntity.ok(recipeOptional.get())
				: ResponseEntity.notFound().build();
	}

	@PostMapping("/api/recipe/new")
	public ResponseEntity<?> addRecipe(@RequestBody Recipe recipe) {
		recipeRepository.addRecipe(recipe);
		return ResponseEntity.ok(recipe.getRecipeId());
	}
}
