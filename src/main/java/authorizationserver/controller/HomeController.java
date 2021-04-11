package authorizationserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="home")
public class HomeController {
	
	@GetMapping("config")
	public ResponseEntity<String> getInfo(){
		System.out.println("infoooo");
		return new ResponseEntity<String>("hihi", HttpStatus.OK);
	}
}
