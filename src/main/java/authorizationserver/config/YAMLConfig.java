package authorizationserver.config;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
	@Value("${address}")
	private String address;
	private String secret;;
	private String identityServer;
	
	public String getBase64UrlSecret() {
		return Base64.getUrlEncoder()
				.withoutPadding()
				.encodeToString(this.secret.getBytes(StandardCharsets.UTF_8));
	}
}
