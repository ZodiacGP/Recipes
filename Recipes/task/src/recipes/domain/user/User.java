package recipes.domain.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class User {

	@Id
	@NotBlank
	@NotNull
	@Email(regexp = ".+@.+\\..+")
	private String email;

	@Size(min = 8)
	@NotBlank
	@NotNull
	private String password;
}
