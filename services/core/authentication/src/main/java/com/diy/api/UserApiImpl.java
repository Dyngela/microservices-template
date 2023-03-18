package com.diy.api;

import com.diy.generated.api.UserApi;
import com.diy.generated.model.UserDto;
import com.diy.mapper.UserModelMapper;
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
public class UserApiImpl implements UserApi {

    UserModelMapper modelMapper;
    UserService userService;


    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        return ResponseEntity.ok(modelMapper.toDto(userService.createUser(modelMapper.dtoToModel(userDto))));
    }

    @Override
    public ResponseEntity<UserDto> createHandler(UserDto userDto) {
        return ResponseEntity.ok(modelMapper.toDto(userService.createHandler(modelMapper.dtoToModel(userDto))));
    }

    @Override
    public ResponseEntity<UserDto> createWorker(UserDto userDto) {
        return ResponseEntity.ok(modelMapper.toDto(userService.createWorker(modelMapper.dtoToModel(userDto))));
    }

    @Override
    public ResponseEntity<String> deleteUserByEmail(String email) {
        return ResponseEntity.ok(userService.deleteUserByEmail(email));
    }

    @Override
    public ResponseEntity<String> deleteUsersByStoresId(Long storeId) {
        return ResponseEntity.ok(userService.deleteUsersByStoresId(storeId));
    }

    @Override
    public ResponseEntity<UserDto> getUserByEmail(String email) {
        return ResponseEntity.ok(modelMapper.toDto(userService.getUserByEmail(email)));
    }

    @Override
    public ResponseEntity<List<UserDto>> getUsersByStoreId(Long storeId) {
        return ResponseEntity.ok(modelMapper.toDtos(userService.getUsersByStoreId(storeId)));
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UserDto userDto) {
        return ResponseEntity.ok(modelMapper.toDto(userService.updateUser(modelMapper.dtoToModel(userDto))));
    }
}
