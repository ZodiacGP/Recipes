package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import recipes.domain.user.User;
import recipes.service.UserService;

import javax.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/api/register")
	public void register(@Valid @RequestBody User user) {
		userService.registerUser(user);
	}
}
