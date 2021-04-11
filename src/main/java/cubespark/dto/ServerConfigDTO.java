package cubespark.dto;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import cubespark.config.YAMLConfig;
import lombok.Data;

@Data
public class ServerConfigDTO {
	private String purchaseUrl;
	private String identityUrl;
	
	public ServerConfigDTO(YAMLConfig config) {
		this.identityUrl = config.getIdentityServer();
		this.purchaseUrl = "http://"+config.getAddress()+":"+config.getPort();
	}
	
}
