package com.diy.api;

import com.diy.generated.api.AuthenticationApi;
import com.diy.generated.model.UserDto;
import com.diy.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationApiImpl implements AuthenticationApi {
    UserService userService;

    @Override
    public ResponseEntity<List<UserDto>> findUsers() {
        log.info("aze");
        return ResponseEntity.ok((userService.test()));
    }
}
