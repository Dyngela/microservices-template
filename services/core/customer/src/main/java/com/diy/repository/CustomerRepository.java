package com.diy.repository;

import com.diy.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity> findByStoreIdAndDeletedAt(Long storeId, LocalDateTime date);
    Optional<CustomerEntity> findByCustomerIdAndDeletedAt(Long customerId, LocalDateTime date);
    Optional<CustomerEntity> findByEmailAndDeletedAt(String email, LocalDateTime date);
}
