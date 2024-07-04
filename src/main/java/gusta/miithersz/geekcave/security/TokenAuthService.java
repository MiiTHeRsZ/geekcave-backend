package gusta.miithersz.geekcave.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import gusta.miithersz.geekcave.auth.user.UserModel;

@Service
public class TokenAuthService {

    @Value("${api.security.token.secret-validation-key}")
    private String secretValidationKey;

    public String tokenAuth(UserModel user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretValidationKey);

            return JWT.create()
                    .withIssuer("Gusta.MiiTHeRsz")
                    .withSubject(user.getUserUsername())
                    .withClaim("id", user.getUserId())
                    .withClaim("role", user.getUserRole())
                    .withExpiresAt(tokenExpiration())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error generating token!", exception);
        }
    }

    private Instant tokenExpiration() {
        return LocalDateTime.now().plusHours(12).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretValidationKey);

            return JWT.require(algorithm)
                    .withIssuer("Gusta.MiiTHeRsz")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("TokenJWT invalid or expired!");
        }
    }

}
