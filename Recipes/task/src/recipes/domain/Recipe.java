package recipes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "recipe")
public class Recipe {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank
	@NotNull
	@Column(name = "name")
	private String name;

	@NotBlank
	@NotNull
	@Column(name = "description")
	private String description;

	@NotEmpty
	@ElementCollection
	@CollectionTable(name = "ingredients")
	private List<String> ingredients;

	@NotEmpty
	@ElementCollection
	@CollectionTable(name = "directions")
	private List<String> directions;
}
