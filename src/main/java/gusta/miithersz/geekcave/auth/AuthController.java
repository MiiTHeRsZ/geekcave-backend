package gusta.miithersz.geekcave.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.auth.user.DTOUserModel;
import gusta.miithersz.geekcave.auth.user.UserModel;
import gusta.miithersz.geekcave.security.TokenAuthService;

@RestController
@RequestMapping("auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenAuthService tokenAuthService;

    @PostMapping
    public ResponseEntity<?> auth(@RequestBody DTOUserModel user) {
        try {
            var token = new UsernamePasswordAuthenticationToken(user.userUsername(), user.userPassword());
            var auth = authenticationManager.authenticate(token);
    
            var tokenJWT = tokenAuthService.tokenAuth((UserModel) auth.getPrincipal());
    
            return new ResponseEntity<DTOAuth>(new DTOAuth(tokenJWT), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
