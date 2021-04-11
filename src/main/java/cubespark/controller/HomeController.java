package cubespark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cubespark.repository.UserRepository;

@RestController
public class HomeController {
//	@Autowired
//	YAMLConfig config;
	@Autowired
	UserRepository repository;
	@GetMapping("/home/config")
	public ResponseEntity<String> getConfig() {
		return new ResponseEntity<String>("{\"identityServer\":\"localhost\"}", HttpStatus.OK);
	}
}
