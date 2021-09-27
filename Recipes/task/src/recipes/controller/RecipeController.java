package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipes.domain.Recipe;
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

	@GetMapping("/search")
	public ResponseEntity<List<Recipe>> searchCategory(@RequestParam Map<String, String> param) {
		if (param.containsKey("category")) {
			return ResponseEntity.ok(recipeService.getRecipeByCategory(param.get("category")));
		}
		if (param.containsKey("name")) {
			return ResponseEntity.ok(recipeService.getRecipeByName(param.get("name")));
		}
		return ResponseEntity.badRequest().build();
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
