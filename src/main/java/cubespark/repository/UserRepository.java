package cubespark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cubespark.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUserName(String userName);
	User findByEmail(String email);
	User save(User user);
	List<User> findAll();
}
