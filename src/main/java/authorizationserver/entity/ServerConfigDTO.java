package authorizationserver.entity;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerConfigDTO {
	public String hostAddress; 
	public String hostName;
	public String hostLoopAddress;
	public String hostLoopName;
	public ServerConfigDTO() {
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
			hostName = InetAddress.getLocalHost().getHostName();
			// Remote address
			hostLoopAddress= InetAddress.getLoopbackAddress().getHostAddress();
			hostLoopName = InetAddress.getLoopbackAddress().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
