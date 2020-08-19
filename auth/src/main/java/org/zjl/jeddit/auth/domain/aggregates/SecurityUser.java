package org.zjl.jeddit.auth.domain.aggregates;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.zjl.jeddit.auth.domain.valueobjects.Password;
import org.zjl.jeddit.auth.domain.valueobjects.Username;

import java.util.Collection;

@Data
public class SecurityUser implements UserDetails {

    private Username username;

    private Password password;

    private boolean locked;

    private boolean enabled;

    private boolean accountExpired;

    private boolean credentialExpired;

    private Collection<? extends GrantedAuthority> authorities;


    @Override
    public String getUsername() {
        return username.getUsername();
    }

    @Override
    public String getPassword() {
        return password.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
