package com.diy.repository;

import com.diy.entity.UserEntity;
import com.diy.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    List<UserEntity> findUserEntitiesByStoreId(Long storeId);
    List<UserEntity> findUserEntitiesByStoreIdAndRoleIsNotAndRoleIsNot(Long storeId, Roles role, Roles roles);

}
