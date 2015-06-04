package bsuir.model.service.implement;

import bsuir.model.dao.UserDao;
import bsuir.model.pojo.Role;
import bsuir.model.pojo.User;
import bsuir.model.pojo.UserStatus;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        User user = userDao.getLogin(login);

        if (user != null) {
            String password = user.getPassword();
            boolean enabled = user.getStatus().equals(UserStatus.ACTIVE);
            boolean accountNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
            boolean credentialsNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
            boolean accountNonLocked = user.getStatus().equals(UserStatus.ACTIVE);

            Collection<GrantedAuthority> authorities = new ArrayList<>();
            for (Role role : user.getRoles()) {
                authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
            }

            org.springframework.security.core.userdetails.User securityUser = new org.springframework.security.core.userdetails.User(login, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
            return securityUser;
        } else {
            throw new UsernameNotFoundException("User Not Found!!!");
        }
    }
}
