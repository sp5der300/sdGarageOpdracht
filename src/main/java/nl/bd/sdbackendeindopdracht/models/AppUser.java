package nl.bd.sdbackendeindopdracht.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import nl.bd.sdbackendeindopdracht.security.enums.Roles;

@Entity
@Table(name = "appUsers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")

    private Long userId;
    @Column(name ="full_name_column")
    private String fullName;
    @Column(name ="username_column")
    private String username;
    @Column(name ="address_column")
    private String address;
    @Column(name ="customer_number_column")
    private int customerNumber;
    @Column(name ="email_column")
    private String email;
    @Column(name ="password_column")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name ="user_role_column")
    private Roles userRole;
    @Column(name ="locked_column")
    private Boolean locked;
    @Column(name ="enabled_column")
    private Boolean enabled;
    @Column(name ="function_column")
    private String function;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
