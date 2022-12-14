package com.stijn.order.service.security;

import com.stijn.order.domain.exceptions.UnauthorizedException;
import com.stijn.order.domain.exceptions.WrongPasswordException;
import com.stijn.order.domain.user.User;
import com.stijn.order.repositories.UserRepository;
import com.stijn.order.domain.user.role.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.NoSuchElementException;

@Service
public class SecurityService {
    private final Logger log = LoggerFactory.getLogger(SecurityService.class);
    private final UserRepository userRepository;

    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateAuthorization(String authorization, Feature feature) {
        UsernamePassword usernamePassword = getUsernamePassword(authorization);
        User user = userRepository.findUserByEmail(usernamePassword.getUsername());
        if (user == null) {
            log.error("Unknown user" + usernamePassword.getUsername());
            throw new NoSuchElementException("Username does not exist");
        }
        if (!user.doesPasswordMatch(usernamePassword.getPassword())) {
            log.error("Password does not match for user " + usernamePassword.getUsername());
            throw new WrongPasswordException();
        }
        if (!user.canHaveAccessTo(feature)) {
            log.error("User " + usernamePassword.getUsername() + " does not have access to " + feature);
            throw new UnauthorizedException();
        }
    }

    private UsernamePassword getUsernamePassword(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        return new UsernamePassword(username, password);
    }
}
