package recipes.domain;

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
@RequiredArgsConstructor
@Entity
@Table(name = "recipe")
public class Recipe {
	@JsonIgnore
	@Id
	@GeneratedValue
	private int id;

	@NotBlank
	@NotNull
	@Column(name = "name")
	private String name;

	@NotBlank
	@NotNull
	@Column(name = "description")
	private String description;

	@NotBlank
	@NotNull
	@Column(name = "category")
	private String category;


	@CreationTimestamp
	@Column(name = "date")
	private LocalDateTime date;

	@NotEmpty
	@ElementCollection
	@CollectionTable(name = "ingredients")
	private List<String> ingredients;

	@NotEmpty
	@ElementCollection
	@CollectionTable(name = "directions")
	private List<String> directions;

	public void copyOf(Recipe recipe) {
		name = recipe.name;
		description = recipe.description;
		category = recipe.category;
		ingredients = recipe.ingredients;
		directions = recipe.directions;
	}

}
