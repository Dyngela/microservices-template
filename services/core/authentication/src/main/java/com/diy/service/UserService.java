package com.diy.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.diy.client.customer.CustomerClient;
import com.diy.client.store.StoreClient;
import com.diy.entity.UserEntity;
import com.diy.enums.Roles;
import com.diy.exception.ExceptionHandler;
import com.diy.generated.model.CustomerDto;
import com.diy.generated.model.StoreDto;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.mapper.UserModelMapper;
import com.diy.model.UserModel;
import com.diy.repository.UserRepository;
import com.diy.security.Authenticate;
import com.diy.security.PasswordEncoder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class UserService implements UserDetailsService {

    UserRepository userRepository;
    UserModelMapper userModelMapper;
    StoreClient storeClient;
    CustomerClient customerClient;
    PasswordEncoder bCryptPasswordEncoder;
    Authenticate authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user with that email"));
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    public String deleteUserByUserId(Long userId) {
        try {
            UserEntity userEntity = userRepository.findById(userId).orElseThrow(() ->
                    new ExceptionHandler("No user found"));
            userEntity.setDeletedAt(LocalDateTime.now());
            userRepository.save(userEntity);
            return "Your account have been successfully deleted";
        } catch (Exception e) {
            log.error("Error while deleting a user: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your account");
        }
    }

    public List<UserModel> getUsersByStoreId(Long id){
        try {
            List<UserEntity> entity = userRepository.findUserEntitiesByStoreId(id);
            return userModelMapper.entitiesToModels(entity, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("Error while getting all user: " + e.getMessage());
            throw new ExceptionHandler("We could not get your employees information");
        }
    }

    public String deleteUsersByStoresId(Long storeId) {
        try {
            List<UserEntity> userEntity = userRepository.findUserEntitiesByStoreId(storeId);
            userEntity.forEach(userEntity1 -> {
                userEntity1.setDeletedAt(LocalDateTime.now());
                userRepository.save(userEntity1);
            });
            return "Your account have been successfully deleted";
        } catch (Exception e) {
            log.error("Error while deleting a user: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your account");
        }
    }

    public UserModel updateUser(UserModel model) {
        try {
            UserEntity userEntity = userRepository.findById(model.getUserId()).orElseThrow(() ->
                    new ExceptionHandler("No user found"));
            userModelMapper.updateStoreFromModel(model, userEntity, new CycleAvoidingMappingContext());
            userEntity.setUpdatedAt(LocalDateTime.now());
            userRepository.save(userEntity);
            return userModelMapper.entityToModel(userEntity, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("Error while update a user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your account");
        }
    }

    public UserModel createUser(UserModel model) {
        try {
            Long storeId = 0L;
            if (model.getRole() == Roles.OWNER) {
                StoreDto request = new StoreDto();
                request.setSiret(model.getSiret());
                request.setStoreName(model.getStoreName());
                request.setSector(model.getSector());
                request.setFirstname(model.getFirstName());
                request.setLastname(model.getLastName());
                request.setEmail(model.getEmail());
                request.setPhoneNumber(model.getPhoneNumber());
                request.setStoreId(model.getStoreId());
                request.setEthAddress(model.getEthAddress());
                StoreDto response = storeClient.createStore(request);
                storeId = response.getStoreId();
            }

            if (storeId != 0L){
                model.setStoreId(storeId);
            }

            if (model.getRole() == Roles.USER) {
                CustomerDto request = new CustomerDto();
                request.setEmail(model.getEmail());
                request.setStoreId(model.getStoreId());
                request.setPhoneNumber(model.getPhoneNumber());
                request.setFirstName(model.getFirstName());
                request.setLastName(model.getLastName());
                request.setEthAddress(model.getEthAddress());
                customerClient.createCustomer(request);
            }
            model.setPassword(bCryptPasswordEncoder.bCryptPasswordEncoder().encode(model.getPassword()));
            UserEntity userEntity = userModelMapper.toEntity(model);
            userEntity.setCreatedAt(LocalDateTime.now());

            userRepository.save(userEntity);
            return userModelMapper.entityToModel(userEntity, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("Error while create a user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your account");
        }
    }

    public String getRoleAccordingToJWT(String  JWT) {
        if (JWT.startsWith("Bearer ")) {
            try {
                String token = JWT.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = com.auth0.jwt.JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(token);
                String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                return roles[0];
            } catch (Exception e) {
                log.warn(e);
                return "authNeeded";
            }
        } else {
            log.warn("else");
            return "authNeeded";
        }
    }

    public String login(String email, String password) {
        try {
            authenticationManager.authenticate(email, password);
        } catch (Exception e) {
            throw new ExceptionHandler("Wrong email or password");
        }
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new ExceptionHandler("Wrong email or password"));
        UserDetails user = loadUserByUsername(email);
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        String jwt = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 10000000L * 600 * 1000))
                .withClaim("storeId", userEntity.getStoreId())
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
        return "Bearer " + jwt;

    }


    public UserModel createHandler(UserModel model) {
        if (model.getStoreId() == null) {
            throw new ExceptionHandler("Your store has to be specified");
        }
        try {
            UserEntity entity = userModelMapper.toEntity(model);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setRole(Roles.HANDLER);
            userRepository.save(entity);
            return userModelMapper.entityToModel(entity, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("Error while create a user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your account");
        }
    }

    public UserModel createWorker(UserModel model) {
        if (model.getStoreId() == null) {
            throw new ExceptionHandler("Your store has to be specified");
        }
        try {
            UserEntity entity = userModelMapper.toEntity(model);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setRole(Roles.WORKER);
            userRepository.save(entity);
            return userModelMapper.entityToModel(entity, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("Error while create a user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your account");
        }
    }
}