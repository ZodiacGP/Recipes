package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.domain.Recipe;
import recipes.service.RecipeService;

import java.util.Map;

@RestController("/api/recipe")
public class RecipeController {

	@Autowired
	RecipeService recipeService;

	@GetMapping("{id}")
	public ResponseEntity<?> getRecipe(@PathVariable int id) {
		Recipe recipe = recipeService.getRecipeById(id);
		return ResponseEntity.status(recipeService.getResponseStatus(recipe)).body(recipe);
	}

	@PostMapping("new")
	public ResponseEntity<?> addRecipe(@RequestBody Recipe recipe) {
		HttpStatus status = recipeService.getResponseStatus(recipe);
		if (status.equals(HttpStatus.OK)) {
			recipeService.save(recipe);
		}
		return ResponseEntity.status(status).body(Map.of("id", recipe.getId()));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteRecipe(@PathVariable int id) {
		Recipe recipe = recipeService.getRecipeById(id);
		HttpStatus status = recipeService.getResponseStatus(recipe);
		if (status.equals(HttpStatus.OK)) {
			recipeService.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(status).build();
	}
}
