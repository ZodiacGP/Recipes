package recipes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

	@GetMapping("/api/recipe")
	public void getRecipe() {
		
	}
}
