package com.diy.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diy.generated.model.LoggingDto;
import com.diy.generated.model.RoleDto;
import com.diy.mapper.UserModelMapperImpl;
import com.diy.security.Authenticate;
import com.diy.security.PasswordEncoder;
import com.diy.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthenticationApiImpl.class, UserService.class})
@ExtendWith(SpringExtension.class)
class AuthenticationApiImplTest {
    @Autowired
    private AuthenticationApiImpl authenticationApiImpl;

}

