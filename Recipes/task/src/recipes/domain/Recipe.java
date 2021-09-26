package recipes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "recipe")
public class Recipe {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ElementCollection
	@CollectionTable(name = "ingredients")
	private List<String> ingredients;


	@ElementCollection
	@CollectionTable(name = "directions")
	private List<String> directions;
}
