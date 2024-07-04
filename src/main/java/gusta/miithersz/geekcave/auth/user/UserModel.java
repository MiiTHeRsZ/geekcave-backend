package gusta.miithersz.geekcave.auth.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "User")
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "userId")
public class UserModel implements UserDetails {

    public UserModel(DTOUserModel user) {
        this(null, user.userUsername(), user.userPassword(), user.userRole());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_username")
    private String userUsername;

    @Column(name = "user_password")
    private String userPassword;

    // ! Uppercase
    @Column(name = "user_role")
    private String userRole;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + userRole));
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userUsername;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;        
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;        
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;        
    }

    @Override
    public boolean isEnabled() {
        return true;        
    }

}
