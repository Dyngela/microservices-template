package com.diy.service;

import com.diy.entity.UserEntity;
import com.diy.generated.model.UserDto;
import com.diy.mapper.UserModelMapper;
import com.diy.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserModelMapper userModelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user with that email"));
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    public List<UserDto> test() {
        UserDto user = new UserDto();
        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(user);
        return userDtos;
    }

//    public UserDto saveUser(UserDto userDto) {
//        UserEntity userEntity = userRepository.findByEmail(userDto.getEmail());
//        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }

//    public void addRoleToUser(String email, String roleName) {
//        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user with that email"));
//        Role role = roleRepository.findByName(roleName);
//        user.getRoles().add(role);
//    }

//    public UserDto getUser(String email) {
//        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user with that email"));
//    }
//
//    public List<UserDto> getUsers() {
//        return userRepository.findAll();
//    }
//
//    public String getRoleAccordingToJWT(JwtChecks JWT) {
//
//        if (JWT.getToken() != null && JWT.getToken().startsWith("Bearer ")) {
//
//            String token = JWT.getToken().substring("Bearer ".length());
//            Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
//            JWTVerifier verifier = com.auth0.jwt.JWT.require(algorithm).build();
//            DecodedJWT decodedJWT = verifier.verify(token);
//            String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
//            return roles[0];
//
//        } else {
//            return "authNeeded";
//        }
//    }


}