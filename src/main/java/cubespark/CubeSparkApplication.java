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
				new User(1, "tiktzuki", "P@ssword1", "tranphanthanhlong18@gmail.com", "091234567","openid read:user write:user"),
				new User(2, "huong", "P@assword1", "huong@gmail.com", "0987654321", "openid read:user"),
				new User(3, "huyen", "P@assword1", "huyen@gmail.com", "0909090909", "openid write:user")
				).collect(Collectors.toList());
		repository.saveAll(users);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CubeSparkApplication.class, args);
	}

}
