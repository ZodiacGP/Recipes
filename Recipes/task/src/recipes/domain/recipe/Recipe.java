package recipes.domain.recipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Recipe {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank
	@NotNull
	private String name;

	@NotBlank
	@NotNull
	private String description;

	@NotBlank
	@NotNull
	private String category;


	@CreationTimestamp
	private LocalDateTime date;

	@NotEmpty
	@ElementCollection
	private List<String> ingredients;

	@NotEmpty
	@ElementCollection
	private List<String> directions;

	@JsonIgnore
	private String email;

	public void copyOf(Recipe recipe) {
		name = recipe.name;
		description = recipe.description;
		category = recipe.category;
		ingredients = recipe.ingredients;
		directions = recipe.directions;
	}

}
