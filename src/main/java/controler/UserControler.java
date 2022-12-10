package controler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserControler {
	
	private final UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAll(){
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody UserDto user) {
		userService.saveUser(user);
	}
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update (@PathVariable ("id") int id, @RequestBody UserDto user) {
		userService.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable ("id") int id) {
		userService.deleteUser(id);
	}
	
}
