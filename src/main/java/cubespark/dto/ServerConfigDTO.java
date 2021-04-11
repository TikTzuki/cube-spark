package cubespark.dto;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import lombok.Data;

@Data
public class ServerConfigDTO {
	private String purchaseUrl;
	private String identityUrl;
	@Autowired
	Environment environment;
	
//	public ServerConfigDTO(YAMLConfig config) {
//		this.identityUrl = config.getIdentityServer();
//		this.purchaseUrl = "http://"+config.getAddress();
//	}
		public ServerConfigDTO() {
		try {
			this.identityUrl = InetAddress.getLocalHost().getHostAddress();
		this.purchaseUrl = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
