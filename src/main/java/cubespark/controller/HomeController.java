package cubespark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cubespark.config.YAMLConfig;
import cubespark.dto.ServerConfigDTO;
import cubespark.entity.User;
import cubespark.repository.UserRepository;

@RestController
public class HomeController {
	@Autowired
	YAMLConfig config;
	@Autowired
	UserRepository repository;
	@GetMapping("/home/config")
	public ResponseEntity<ServerConfigDTO> getConfig() {
		return new ResponseEntity<ServerConfigDTO>(new ServerConfigDTO(config), HttpStatus.OK);
	}
}
