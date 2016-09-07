package ua.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.web.common.Credentials;
import ua.web.common.DbUser;
import ua.web.common.Role;
import ua.web.manager.DbManager;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private DbManager dbManager;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        Credentials dbUser = dbManager.getUserByName(user);
        if (dbUser == null) {
            throw new UsernameNotFoundException("User " + user + " is not found.");
        }

        final Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role : dbUser.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new DbUser(dbUser, dbUser.getName(), dbUser.getPass(), true, true, true, true, authorities);
    }
}
