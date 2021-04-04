package cubespark;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cubespark.repository.UserRepository;
import cubespark.entity.User;

@SpringBootApplication
public class CubeSparkApplication {
		@Autowired
	UserRepository repository;
		
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101, "tiktuzki", "password", "tranphanthanhlong18@gmail.com", "091234567","openid product order users"),
				new User(102, "huong", "password", "huong@gmail.com", "0987654321", "openid product read:order"),
				new User(103, "huyen", "password", "huyen@gmail.com", "0909090909", "openid read:product order")
				).collect(Collectors.toList());
		repository.saveAll(users);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CubeSparkApplication.class, args);
	}

}
