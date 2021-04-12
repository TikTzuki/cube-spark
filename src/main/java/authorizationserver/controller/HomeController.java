package authorizationserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import authorizationserver.config.YAMLConfig;
import authorizationserver.entity.ServerConfigDTO;

@RestController
@RequestMapping(value="home")
public class HomeController {
	@Autowired
	YAMLConfig config;
	
	@GetMapping("config")
	public ResponseEntity<ServerConfigDTO> getInfo(){
		return new ResponseEntity<ServerConfigDTO>(new ServerConfigDTO(), HttpStatus.OK);
	}
	
}
