package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipes.domain.recipe.Recipe;
import recipes.service.RecipeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
@Validated
public class RecipeController {

	@Autowired
	RecipeService recipeService;

	@GetMapping("/{id}")
	public Recipe getRecipe(@PathVariable int id) {
		return recipeService.getRecipeById(id);
	}

	@PostMapping("/new")
	public Map<String, Integer> addRecipe(@RequestBody @Valid Recipe recipe) {
		return Map.of("id", recipeService.save(recipe));
	}

	@GetMapping(value = "/search", params = "name")
	public ResponseEntity<List<Recipe>> searchName(@RequestParam String name) {
		return ResponseEntity.ok(recipeService.getRecipeByName(name));
	}

	@GetMapping(value = "/search", params = "category")
	public ResponseEntity<List<Recipe>> searchCategory(@RequestParam String category) {
		return ResponseEntity.ok(recipeService.getRecipeByCategory(category));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid Recipe recipe) {
		recipeService.update(id, recipe);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRecipe(@PathVariable int id) {
		recipeService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
