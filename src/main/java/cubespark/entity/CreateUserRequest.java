package cubespark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
	String userName;
	String password;
	String email;
	String phoneNumber;
	String scope;
}
