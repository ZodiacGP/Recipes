package recipes.domain;

import lombok.Data;

@Data
public class RecipeId {
	private final int id;
	private static int inc = 0;

	public RecipeId() {
		this.id = ++inc;
	}
}
