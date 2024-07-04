package gusta.miithersz.geekcave.auth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDetails getUser(String username) {
        return userRepository.findByUserUsername(username);
    }

    public UserModel postUser(UserModel user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

        return userRepository.save(user);
    }

}
