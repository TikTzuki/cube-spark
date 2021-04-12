package authorizationserver.entity;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Base64;

import authorizationserver.config.YAMLConfig;
import lombok.Data;

@Data
public class ServerConfigDTO {
	private String purchaseUrl;
	private String identityUrl;
	
	public ServerConfigDTO(YAMLConfig config) {
		this.identityUrl = config.getIdentityServer();
		this.purchaseUrl = config.getAddress();
	}

}
