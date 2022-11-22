package com.stijn.order.api.security;

import com.stijn.order.domain.user.role.Feature;
import com.stijn.order.service.security.SecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class SecurityController {

    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void login(@RequestHeader String authorization) {
        securityService.validateAuthorization(authorization, Feature.LOGIN);
    }
}
