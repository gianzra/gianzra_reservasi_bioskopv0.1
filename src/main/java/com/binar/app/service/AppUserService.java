package com.binar.app.service;

import com.binar.app.model.AppUser;
import com.binar.app.repository.AppUserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.logging.Logger;

@Service
@Transactional
public class AppUserService implements UserDetailsService {


    private static final Logger logger = (Logger) LoggerFactory.getLogger(AppUserService.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("user with username '%s' not found", username)));
    }

    /**
     * @param user
     * @return
     */
    public AppUser registerAppUser(AppUser user) {
        boolean userExist = appUserRepository.findByUsername(user.getUsername()).isPresent();
        if(userExist) {
            throw new RuntimeException(
                    String.format("User with email '%s' already exist", user.getUsername())
            );
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return appUserRepository.save(user);
    }

}
