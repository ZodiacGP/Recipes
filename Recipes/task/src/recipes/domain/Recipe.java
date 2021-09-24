package recipes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Recipe {
	@JsonIgnore
	private final RecipeId recipeId = new RecipeId();
	private final String name;
	private final String description;
	private final List<String> ingredients;
	private final List<String> directions;
}
