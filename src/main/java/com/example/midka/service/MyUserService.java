package com.example.midka.service;

import com.example.midka.model.Permission;
import com.example.midka.model.User;
import com.example.midka.repository.PermissionRep;
import com.example.midka.repository.UserRep;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyUserService implements UserDetailsService {
    @Autowired
    private UserRep userRep;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PermissionRep permissionRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User check = userRep.findByEmail(username);
        if(Objects.nonNull(check)){
            return check;
        }
        throw new UsernameNotFoundException("User not fond");
    }

    public void register(User model){
        User check = userRep.findByEmail(model.getEmail());
        if(check == null){
            model.setPassword(passwordEncoder.encode(model.getPassword()));
            List<Permission> permissions = List.of(permissionRep.findByName("ROLE_USER"));
            model.setPermissions(permissions);
            userRep.save(model);
        }
    }
}
