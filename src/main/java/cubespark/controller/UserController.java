package cubespark.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cubespark.config.YAMLConfig;
import cubespark.entity.CreateUserRequest;
import cubespark.entity.User;
import cubespark.repository.UserRepository;
import cubespark.util.JwtUtil;

@RestController
@RequestMapping("api")
public class UserController {
	@Autowired
	UserRepository repository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private YAMLConfig config;
	
	@PostMapping("/createUser")
	public ResponseEntity<String> createAccountFormAnotherServer(@RequestBody CreateUserRequest request){
		if(validateCreateUserRequest(request)) {
			User newUser = repository.save(new User(0, 
					request.getUserName(), 
					request.getPassword(), 
					request.getEmail(), 
					request.getPhoneNumber(), 
					request.getScope()));
			JSONObject newUserObject = new JSONObject();
			newUserObject.put("id", newUser.getId());
			newUserObject.put("userName", newUser.getUserName());
			newUserObject.put("password", newUser.getPassword());
			newUserObject.put("email", newUser.getEmail());
			newUserObject.put("scope", newUser.getScope());
			return new ResponseEntity<String>(newUserObject.toString(), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createAccount(@RequestBody CreateUserRequest request){
		if(validateCreateUserRequest(request)) {
			User newUser = repository.save(new User(0, 
					request.getUserName(), 
					request.getPassword(), 
					request.getEmail(), 
					request.getPhoneNumber(), 
					request.getScope()));
			return new ResponseEntity<User>(newUser, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = repository.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id){
		Optional<User> userOpt = repository.findById(id);
		if(userOpt.isPresent())
			return new ResponseEntity<User>(userOpt.get(), HttpStatus.OK);
		return new ResponseEntity<User>(new User(),HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable int id){
		User updatedUser = null;
		if(repository.findById(id).isPresent()) {
			updatedUser= repository.save(newUser);
			return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<List<User>> deleteUser(@PathVariable int id){
		repository.deleteById(id);
		return new ResponseEntity<List<User>>(repository.findAll(),HttpStatus.OK);
	}
	
	private boolean validateCreateUserRequest(CreateUserRequest request) {
		return true;
	}
}
