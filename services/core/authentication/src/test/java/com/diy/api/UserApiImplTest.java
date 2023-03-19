package com.diy.api;

import com.diy.generated.model.UserDto;
import com.diy.mapper.UserModelMapper;
import com.diy.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserApiImpl.class, UserModelMapper.class, UserService.class})
@ExtendWith(SpringExtension.class)
class UserApiImplTest {
    @Autowired
    private UserApiImpl userApiImpl;



}

