package com.diy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.client.customer.CustomerClient;
import com.diy.client.store.StoreClient;
import com.diy.entity.UserEntity;
import com.diy.enums.Roles;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.mapper.UserModelMapper;
import com.diy.model.UserModel;
import com.diy.repository.UserRepository;
import com.diy.security.Authenticate;
import com.diy.security.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class, PasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private Authenticate authenticate;

    @MockBean
    private CustomerClient customerClient;

    @MockBean
    private StoreClient storeClient;

    @MockBean
    private UserModelMapper userModelMapper;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        Optional<UserEntity> ofResult = Optional.of(userEntity);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = userService.loadUserByUsername("jane.doe@example.org");
        assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        UserEntity userEntity = mock(UserEntity.class);
        when(userEntity.getEmail()).thenThrow(new UsernameNotFoundException("Msg"));
        when(userEntity.getPassword()).thenThrow(new UsernameNotFoundException("Msg"));
        when(userEntity.getRole()).thenReturn(Roles.USER);
        doNothing().when(userEntity).setCreatedAt((LocalDateTime) any());
        doNothing().when(userEntity).setCustomerId((Long) any());
        doNothing().when(userEntity).setDeletedAt((LocalDateTime) any());
        doNothing().when(userEntity).setEmail((String) any());
        doNothing().when(userEntity).setEthAddress((String) any());
        doNothing().when(userEntity).setPassword((String) any());
        doNothing().when(userEntity).setRole((Roles) any());
        doNothing().when(userEntity).setStoreId((Long) any());
        doNothing().when(userEntity).setUpdatedAt((LocalDateTime) any());
        doNothing().when(userEntity).setUserId((Long) any());
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        Optional<UserEntity> ofResult = Optional.of(userEntity);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername("jane.doe@example.org"));
        verify(userRepository).findByEmail((String) any());
        verify(userEntity).getRole();
        verify(userEntity).getEmail();
        verify(userEntity).setCreatedAt((LocalDateTime) any());
        verify(userEntity).setCustomerId((Long) any());
        verify(userEntity).setDeletedAt((LocalDateTime) any());
        verify(userEntity).setEmail((String) any());
        verify(userEntity).setEthAddress((String) any());
        verify(userEntity).setPassword((String) any());
        verify(userEntity).setRole((Roles) any());
        verify(userEntity).setStoreId((Long) any());
        verify(userEntity).setUpdatedAt((LocalDateTime) any());
        verify(userEntity).setUserId((Long) any());
    }

    /**
     * Method under test: {@link UserService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername4() throws UsernameNotFoundException {
        when(userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        UserEntity userEntity = mock(UserEntity.class);
        when(userEntity.getEmail()).thenReturn("jane.doe@example.org");
        when(userEntity.getPassword()).thenReturn("iloveyou");
        when(userEntity.getRole()).thenReturn(Roles.USER);
        doNothing().when(userEntity).setCreatedAt((LocalDateTime) any());
        doNothing().when(userEntity).setCustomerId((Long) any());
        doNothing().when(userEntity).setDeletedAt((LocalDateTime) any());
        doNothing().when(userEntity).setEmail((String) any());
        doNothing().when(userEntity).setEthAddress((String) any());
        doNothing().when(userEntity).setPassword((String) any());
        doNothing().when(userEntity).setRole((Roles) any());
        doNothing().when(userEntity).setStoreId((Long) any());
        doNothing().when(userEntity).setUpdatedAt((LocalDateTime) any());
        doNothing().when(userEntity).setUserId((Long) any());
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername("jane.doe@example.org"));
        verify(userRepository).findByEmail((String) any());
        verify(userEntity).setCreatedAt((LocalDateTime) any());
        verify(userEntity).setCustomerId((Long) any());
        verify(userEntity).setDeletedAt((LocalDateTime) any());
        verify(userEntity).setEmail((String) any());
        verify(userEntity).setEthAddress((String) any());
        verify(userEntity).setPassword((String) any());
        verify(userEntity).setRole((Roles) any());
        verify(userEntity).setStoreId((Long) any());
        verify(userEntity).setUpdatedAt((LocalDateTime) any());
        verify(userEntity).setUserId((Long) any());
    }

    /**
     * Method under test: {@link UserService#deleteUserByEmail(String)}
     */
    @Test
    void testDeleteUserByEmail() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        Optional<UserEntity> ofResult = Optional.of(userEntity);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setCustomerId(1L);
        userEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setEmail("jane.doe@example.org");
        userEntity1.setEthAddress("42 Main St");
        userEntity1.setPassword("iloveyou");
        userEntity1.setRole(Roles.USER);
        userEntity1.setStoreId(1L);
        userEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setUserId(1L);
        when(userRepository.save((UserEntity) any())).thenReturn(userEntity1);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        assertEquals("Your account have been successfully deleted",
                userService.deleteUserByEmail("jane.doe@example.org"));
        verify(userRepository).save((UserEntity) any());
        verify(userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#deleteUserByEmail(String)}
     */
    @Test
    void testDeleteUserByEmail2() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        Optional<UserEntity> ofResult = Optional.of(userEntity);
        when(userRepository.save((UserEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> userService.deleteUserByEmail("jane.doe@example.org"));
        verify(userRepository).save((UserEntity) any());
        verify(userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#getUsersByStoreId(Long)}
     */
    @Test
    void testGetUsersByStoreId() {
        when(userRepository.findUserEntitiesByStoreIdAndRoleIsNotAndRoleIsNot((Long) any(), (Roles) any(), (Roles) any()))
                .thenReturn(new ArrayList<>());
        ArrayList<UserModel> userModelList = new ArrayList<>();
        when(userModelMapper.entitiesToModels((List<UserEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(userModelList);
        List<UserModel> actualUsersByStoreId = userService.getUsersByStoreId(1L);
        assertSame(userModelList, actualUsersByStoreId);
        assertTrue(actualUsersByStoreId.isEmpty());
        verify(userRepository).findUserEntitiesByStoreIdAndRoleIsNotAndRoleIsNot((Long) any(), (Roles) any(),
                (Roles) any());
        verify(userModelMapper).entitiesToModels((List<UserEntity>) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link UserService#getUsersByStoreId(Long)}
     */
    @Test
    void testGetUsersByStoreId2() {
        when(userRepository.findUserEntitiesByStoreIdAndRoleIsNotAndRoleIsNot((Long) any(), (Roles) any(), (Roles) any()))
                .thenReturn(new ArrayList<>());
        when(userModelMapper.entitiesToModels((List<UserEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> userService.getUsersByStoreId(1L));
        verify(userRepository).findUserEntitiesByStoreIdAndRoleIsNotAndRoleIsNot((Long) any(), (Roles) any(),
                (Roles) any());
        verify(userModelMapper).entitiesToModels((List<UserEntity>) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link UserService#deleteUsersByStoresId(Long)}
     */
    @Test
    void testDeleteUsersByStoresId() {
        when(userRepository.findUserEntitiesByStoreId((Long) any())).thenReturn(new ArrayList<>());
        assertEquals("Your account have been successfully deleted", userService.deleteUsersByStoresId(1L));
        verify(userRepository).findUserEntitiesByStoreId((Long) any());
    }

    /**
     * Method under test: {@link UserService#deleteUsersByStoresId(Long)}
     */
    @Test
    void testDeleteUsersByStoresId2() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);

        ArrayList<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(userEntity);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setCustomerId(1L);
        userEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setEmail("jane.doe@example.org");
        userEntity1.setEthAddress("42 Main St");
        userEntity1.setPassword("iloveyou");
        userEntity1.setRole(Roles.USER);
        userEntity1.setStoreId(1L);
        userEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setUserId(1L);
        when(userRepository.save((UserEntity) any())).thenReturn(userEntity1);
        when(userRepository.findUserEntitiesByStoreId((Long) any())).thenReturn(userEntityList);
        assertEquals("Your account have been successfully deleted", userService.deleteUsersByStoresId(1L));
        verify(userRepository).save((UserEntity) any());
        verify(userRepository).findUserEntitiesByStoreId((Long) any());
    }

    /**
     * Method under test: {@link UserService#deleteUsersByStoresId(Long)}
     */
    @Test
    void testDeleteUsersByStoresId3() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setCustomerId(2L);
        userEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setEmail("john.smith@example.org");
        userEntity1.setEthAddress("17 High St");
        userEntity1.setPassword("Your account have been successfully deleted");
        userEntity1.setRole(Roles.ADMIN);
        userEntity1.setStoreId(2L);
        userEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setUserId(2L);

        ArrayList<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(userEntity1);
        userEntityList.add(userEntity);

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity2.setCustomerId(1L);
        userEntity2.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity2.setEmail("jane.doe@example.org");
        userEntity2.setEthAddress("42 Main St");
        userEntity2.setPassword("iloveyou");
        userEntity2.setRole(Roles.USER);
        userEntity2.setStoreId(1L);
        userEntity2.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity2.setUserId(1L);
        when(userRepository.save((UserEntity) any())).thenReturn(userEntity2);
        when(userRepository.findUserEntitiesByStoreId((Long) any())).thenReturn(userEntityList);
        assertEquals("Your account have been successfully deleted", userService.deleteUsersByStoresId(1L));
        verify(userRepository, atLeast(1)).save((UserEntity) any());
        verify(userRepository).findUserEntitiesByStoreId((Long) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(UserModel)}
     */
    @Test
    void testUpdateUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        Optional<UserEntity> ofResult = Optional.of(userEntity);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setCustomerId(1L);
        userEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setEmail("jane.doe@example.org");
        userEntity1.setEthAddress("42 Main St");
        userEntity1.setPassword("iloveyou");
        userEntity1.setRole(Roles.USER);
        userEntity1.setStoreId(1L);
        userEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setUserId(1L);
        when(userRepository.save((UserEntity) any())).thenReturn(userEntity1);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        UserModel userModel = new UserModel();
        when(userModelMapper.entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(userModel);
        doNothing().when(userModelMapper)
                .updateStoreFromModel((UserModel) any(), (UserEntity) any(), (CycleAvoidingMappingContext) any());
        assertSame(userModel, userService.updateUser(new UserModel()));
        verify(userRepository).save((UserEntity) any());
        verify(userRepository).findByEmail((String) any());
        verify(userModelMapper).entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any());
        verify(userModelMapper).updateStoreFromModel((UserModel) any(), (UserEntity) any(),
                (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(UserModel)}
     */
    @Test
    void testUpdateUser2() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        Optional<UserEntity> ofResult = Optional.of(userEntity);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setCustomerId(1L);
        userEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setEmail("jane.doe@example.org");
        userEntity1.setEthAddress("42 Main St");
        userEntity1.setPassword("iloveyou");
        userEntity1.setRole(Roles.USER);
        userEntity1.setStoreId(1L);
        userEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setUserId(1L);
        when(userRepository.save((UserEntity) any())).thenReturn(userEntity1);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(userModelMapper.entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new UsernameNotFoundException("Msg"));
        doThrow(new UsernameNotFoundException("Msg")).when(userModelMapper)
                .updateStoreFromModel((UserModel) any(), (UserEntity) any(), (CycleAvoidingMappingContext) any());
        assertThrows(ExceptionHandler.class, () -> userService.updateUser(new UserModel()));
        verify(userRepository).findByEmail((String) any());
        verify(userModelMapper).updateStoreFromModel((UserModel) any(), (UserEntity) any(),
                (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link UserService#createUser(UserModel)}
     */
    @Test
    void testCreateUser() {
        assertThrows(ExceptionHandler.class, () -> userService.createUser(new UserModel()));
    }

    /**
     * Method under test: {@link UserService#createUser(UserModel)}
     */
    @Test
    void testCreateUser2() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        when(userRepository.save((UserEntity) any())).thenReturn(userEntity);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setCustomerId(1L);
        userEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setEmail("jane.doe@example.org");
        userEntity1.setEthAddress("42 Main St");
        userEntity1.setPassword("iloveyou");
        userEntity1.setRole(Roles.USER);
        userEntity1.setStoreId(1L);
        userEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setUserId(1L);
        UserModel userModel = new UserModel();
        when(userModelMapper.entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(userModel);
        when(userModelMapper.toEntity((UserModel) any())).thenReturn(userEntity1);

        UserModel userModel1 = new UserModel();
        userModel1.setPassword("iloveyou");
        assertSame(userModel, userService.createUser(userModel1));
        verify(userRepository).save((UserEntity) any());
        verify(userModelMapper).toEntity((UserModel) any());
        verify(userModelMapper).entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link UserService#createUser(UserModel)}
     */
    @Test
    void testCreateUser3() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        when(userRepository.save((UserEntity) any())).thenReturn(userEntity);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setCustomerId(1L);
        userEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setEmail("jane.doe@example.org");
        userEntity1.setEthAddress("42 Main St");
        userEntity1.setPassword("iloveyou");
        userEntity1.setRole(Roles.USER);
        userEntity1.setStoreId(1L);
        userEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setUserId(1L);
        when(userModelMapper.entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        when(userModelMapper.toEntity((UserModel) any())).thenReturn(userEntity1);

        UserModel userModel = new UserModel();
        userModel.setPassword("iloveyou");
        assertThrows(ExceptionHandler.class, () -> userService.createUser(userModel));
        verify(userRepository).save((UserEntity) any());
        verify(userModelMapper).toEntity((UserModel) any());
        verify(userModelMapper).entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link UserService#getRoleAccordingToJWT(String)}
     */
    @Test
    void testGetRoleAccordingToJWT() {
        assertEquals("authNeeded", userService.getRoleAccordingToJWT("JWT"));
        assertEquals("authNeeded", userService.getRoleAccordingToJWT("Bearer "));
    }

    /**
     * Method under test: {@link UserService#login(String, String)}
     */
    @Test
    void testLogin() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        Optional<UserEntity> ofResult = Optional.of(userEntity);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        doNothing().when(authenticate).authenticate((String) any(), (String) any());
        userService.login("jane.doe@example.org", "iloveyou");
        verify(userRepository, atLeast(1)).findByEmail((String) any());
        verify(authenticate).authenticate((String) any(), (String) any());
    }

    /**
     * Method under test: {@link UserService#login(String, String)}
     */
    @Test
    void testLogin2() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        Optional<UserEntity> ofResult = Optional.of(userEntity);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        doThrow(new Exception()).when(authenticate).authenticate((String) any(), (String) any());
        assertThrows(ExceptionHandler.class, () -> userService.login("jane.doe@example.org", "iloveyou"));
        verify(authenticate).authenticate((String) any(), (String) any());
    }

    /**
     * Method under test: {@link UserService#login(String, String)}
     */
    @Test
    void testLogin3() throws Exception {
        UserEntity userEntity = mock(UserEntity.class);
        when(userEntity.getStoreId()).thenThrow(new ExceptionHandler("An error occurred"));
        when(userEntity.getEmail()).thenReturn("jane.doe@example.org");
        when(userEntity.getPassword()).thenReturn("iloveyou");
        when(userEntity.getRole()).thenReturn(Roles.USER);
        doNothing().when(userEntity).setCreatedAt((LocalDateTime) any());
        doNothing().when(userEntity).setCustomerId((Long) any());
        doNothing().when(userEntity).setDeletedAt((LocalDateTime) any());
        doNothing().when(userEntity).setEmail((String) any());
        doNothing().when(userEntity).setEthAddress((String) any());
        doNothing().when(userEntity).setPassword((String) any());
        doNothing().when(userEntity).setRole((Roles) any());
        doNothing().when(userEntity).setStoreId((Long) any());
        doNothing().when(userEntity).setUpdatedAt((LocalDateTime) any());
        doNothing().when(userEntity).setUserId((Long) any());
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        Optional<UserEntity> ofResult = Optional.of(userEntity);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        doNothing().when(authenticate).authenticate((String) any(), (String) any());
        assertThrows(ExceptionHandler.class, () -> userService.login("jane.doe@example.org", "iloveyou"));
        verify(userRepository, atLeast(1)).findByEmail((String) any());
        verify(userEntity).getRole();
        verify(userEntity).getStoreId();
        verify(userEntity).getEmail();
        verify(userEntity).getPassword();
        verify(userEntity).setCreatedAt((LocalDateTime) any());
        verify(userEntity).setCustomerId((Long) any());
        verify(userEntity).setDeletedAt((LocalDateTime) any());
        verify(userEntity).setEmail((String) any());
        verify(userEntity).setEthAddress((String) any());
        verify(userEntity).setPassword((String) any());
        verify(userEntity).setRole((Roles) any());
        verify(userEntity).setStoreId((Long) any());
        verify(userEntity).setUpdatedAt((LocalDateTime) any());
        verify(userEntity).setUserId((Long) any());
        verify(authenticate).authenticate((String) any(), (String) any());
    }

    /**
     * Method under test: {@link UserService#login(String, String)}
     */
    @Test
    void testLogin5() throws Exception {
        when(userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        UserEntity userEntity = mock(UserEntity.class);
        when(userEntity.getStoreId()).thenThrow(new ExceptionHandler("An error occurred"));
        when(userEntity.getEmail()).thenReturn("jane.doe@example.org");
        when(userEntity.getPassword()).thenReturn("iloveyou");
        when(userEntity.getRole()).thenReturn(Roles.USER);
        doNothing().when(userEntity).setCreatedAt((LocalDateTime) any());
        doNothing().when(userEntity).setCustomerId((Long) any());
        doNothing().when(userEntity).setDeletedAt((LocalDateTime) any());
        doNothing().when(userEntity).setEmail((String) any());
        doNothing().when(userEntity).setEthAddress((String) any());
        doNothing().when(userEntity).setPassword((String) any());
        doNothing().when(userEntity).setRole((Roles) any());
        doNothing().when(userEntity).setStoreId((Long) any());
        doNothing().when(userEntity).setUpdatedAt((LocalDateTime) any());
        doNothing().when(userEntity).setUserId((Long) any());
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        doNothing().when(authenticate).authenticate((String) any(), (String) any());
        assertThrows(ExceptionHandler.class, () -> userService.login("jane.doe@example.org", "iloveyou"));
        verify(userRepository).findByEmail((String) any());
        verify(userEntity).setCreatedAt((LocalDateTime) any());
        verify(userEntity).setCustomerId((Long) any());
        verify(userEntity).setDeletedAt((LocalDateTime) any());
        verify(userEntity).setEmail((String) any());
        verify(userEntity).setEthAddress((String) any());
        verify(userEntity).setPassword((String) any());
        verify(userEntity).setRole((Roles) any());
        verify(userEntity).setStoreId((Long) any());
        verify(userEntity).setUpdatedAt((LocalDateTime) any());
        verify(userEntity).setUserId((Long) any());
        verify(authenticate).authenticate((String) any(), (String) any());
    }

    /**
     * Method under test: {@link UserService#createHandler(UserModel)}
     */
    @Test
    void testCreateHandler() {
        assertThrows(ExceptionHandler.class, () -> userService.createHandler(new UserModel()));
    }

    /**
     * Method under test: {@link UserService#createHandler(UserModel)}
     */
    @Test
    void testCreateHandler3() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        when(userRepository.save((UserEntity) any())).thenReturn(userEntity);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setCustomerId(1L);
        userEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setEmail("jane.doe@example.org");
        userEntity1.setEthAddress("42 Main St");
        userEntity1.setPassword("iloveyou");
        userEntity1.setRole(Roles.USER);
        userEntity1.setStoreId(1L);
        userEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setUserId(1L);
        UserModel userModel = new UserModel();
        when(userModelMapper.entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(userModel);
        when(userModelMapper.toEntity((UserModel) any())).thenReturn(userEntity1);
        LocalDateTime createdAt = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime updatedAt = LocalDateTime.of(1, 1, 1, 1, 1);
        assertSame(userModel,
                userService.createHandler(new UserModel(1L, "jane.doe@example.org", "iloveyou", "Jane", "Doe", "6625550144",
                        "42 Main St", 1L, Roles.USER, createdAt, updatedAt, LocalDateTime.of(1, 1, 1, 1, 1),
                        "Your store has to be specified", "Your store has to be specified", "Your store has to be specified")));
        verify(userRepository).save((UserEntity) any());
        verify(userModelMapper).toEntity((UserModel) any());
        verify(userModelMapper).entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link UserService#createHandler(UserModel)}
     */
    @Test
    void testCreateHandler4() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        when(userRepository.save((UserEntity) any())).thenReturn(userEntity);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setCustomerId(1L);
        userEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setEmail("jane.doe@example.org");
        userEntity1.setEthAddress("42 Main St");
        userEntity1.setPassword("iloveyou");
        userEntity1.setRole(Roles.USER);
        userEntity1.setStoreId(1L);
        userEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setUserId(1L);
        when(userModelMapper.entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        when(userModelMapper.toEntity((UserModel) any())).thenReturn(userEntity1);
        LocalDateTime createdAt = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime updatedAt = LocalDateTime.of(1, 1, 1, 1, 1);
        assertThrows(ExceptionHandler.class,
                () -> userService.createHandler(new UserModel(1L, "jane.doe@example.org", "iloveyou", "Jane", "Doe",
                        "6625550144", "42 Main St", 1L, Roles.USER, createdAt, updatedAt, LocalDateTime.of(1, 1, 1, 1, 1),
                        "Your store has to be specified", "Your store has to be specified", "Your store has to be specified")));
        verify(userRepository).save((UserEntity) any());
        verify(userModelMapper).toEntity((UserModel) any());
        verify(userModelMapper).entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link UserService#createWorker(UserModel)}
     */
    @Test
    void testCreateWorker() {
        assertThrows(ExceptionHandler.class, () -> userService.createWorker(new UserModel()));
    }

    /**
     * Method under test: {@link UserService#createWorker(UserModel)}
     */
    @Test
    void testCreateWorker3() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        when(userRepository.save((UserEntity) any())).thenReturn(userEntity);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setCustomerId(1L);
        userEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setEmail("jane.doe@example.org");
        userEntity1.setEthAddress("42 Main St");
        userEntity1.setPassword("iloveyou");
        userEntity1.setRole(Roles.USER);
        userEntity1.setStoreId(1L);
        userEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setUserId(1L);
        UserModel userModel = new UserModel();
        when(userModelMapper.entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(userModel);
        when(userModelMapper.toEntity((UserModel) any())).thenReturn(userEntity1);
        LocalDateTime createdAt = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime updatedAt = LocalDateTime.of(1, 1, 1, 1, 1);
        assertSame(userModel,
                userService.createWorker(new UserModel(1L, "jane.doe@example.org", "iloveyou", "Jane", "Doe", "6625550144",
                        "42 Main St", 1L, Roles.USER, createdAt, updatedAt, LocalDateTime.of(1, 1, 1, 1, 1),
                        "Your store has to be specified", "Your store has to be specified", "Your store has to be specified")));
        verify(userRepository).save((UserEntity) any());
        verify(userModelMapper).toEntity((UserModel) any());
        verify(userModelMapper).entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link UserService#createWorker(UserModel)}
     */
    @Test
    void testCreateWorker4() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        when(userRepository.save((UserEntity) any())).thenReturn(userEntity);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setCustomerId(1L);
        userEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setEmail("jane.doe@example.org");
        userEntity1.setEthAddress("42 Main St");
        userEntity1.setPassword("iloveyou");
        userEntity1.setRole(Roles.USER);
        userEntity1.setStoreId(1L);
        userEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity1.setUserId(1L);
        when(userModelMapper.entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        when(userModelMapper.toEntity((UserModel) any())).thenReturn(userEntity1);
        LocalDateTime createdAt = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime updatedAt = LocalDateTime.of(1, 1, 1, 1, 1);
        assertThrows(ExceptionHandler.class,
                () -> userService.createWorker(new UserModel(1L, "jane.doe@example.org", "iloveyou", "Jane", "Doe",
                        "6625550144", "42 Main St", 1L, Roles.USER, createdAt, updatedAt, LocalDateTime.of(1, 1, 1, 1, 1),
                        "Your store has to be specified", "Your store has to be specified", "Your store has to be specified")));
        verify(userRepository).save((UserEntity) any());
        verify(userModelMapper).toEntity((UserModel) any());
        verify(userModelMapper).entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link UserService#getUserByEmail(String)}
     */
    @Test
    void testGetUserByEmail() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        Optional<UserEntity> ofResult = Optional.of(userEntity);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        UserModel userModel = new UserModel();
        when(userModelMapper.entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(userModel);
        assertSame(userModel, userService.getUserByEmail("jane.doe@example.org"));
        verify(userRepository).findByEmail((String) any());
        verify(userModelMapper).entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link UserService#getUserByEmail(String)}
     */
    @Test
    void testGetUserByEmail2() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setCustomerId(1L);
        userEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setEmail("jane.doe@example.org");
        userEntity.setEthAddress("42 Main St");
        userEntity.setPassword("iloveyou");
        userEntity.setRole(Roles.USER);
        userEntity.setStoreId(1L);
        userEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        userEntity.setUserId(1L);
        Optional<UserEntity> ofResult = Optional.of(userEntity);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(userModelMapper.entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> userService.getUserByEmail("jane.doe@example.org"));
        verify(userRepository).findByEmail((String) any());
        verify(userModelMapper).entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link UserService#getUserByEmail(String)}
     */
    @Test
    void testGetUserByEmail3() {
        when(userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        when(userModelMapper.entityToModel((UserEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new UserModel());
        assertThrows(ExceptionHandler.class, () -> userService.getUserByEmail("jane.doe@example.org"));
        verify(userRepository).findByEmail((String) any());
    }
}

