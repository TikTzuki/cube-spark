package cubespark.util;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import cubespark.config.YAMLConfig;
import cubespark.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtUtil {
	@Autowired
	UserRepository userRepository;
	
	//Config
	@Autowired
	private YAMLConfig config;
	
	// Lấy ra username của token
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser()
				.setSigningKey(config.getBase64UrlSecret())
				.parseClaimsJws(token).getBody();
	}
	
	//Kiểm tra thời hạn token
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		String signature = "";
		String headerFromToken = token.substring(0, token.indexOf("."));
		String payloadFromToken = token.substring(token.indexOf(".")+1 , token.lastIndexOf("."));
		String signFromToken = token.substring(token.lastIndexOf(".")+1);
		System.out.println("header: " + headerFromToken);
		System.out.println("payload: "+payloadFromToken);
		System.out.println("signature form token: " + signFromToken);
		try {
			signature = SignatureAlgorithm.signRequest(headerFromToken, payloadFromToken, config.getSecret());
		} catch (IOException e) {
			return false;
		}
		System.out.println("signature manual handled: " + signature);
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token) && signature.equals(signFromToken));
	}
}
