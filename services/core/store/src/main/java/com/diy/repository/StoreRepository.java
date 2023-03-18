package com.diy.repository;

import com.diy.entity.StoreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long>, JpaSpecificationExecutor<StoreEntity> {
    Optional<StoreEntity> findByStoreNameAndDeletedAt(String name, LocalDateTime date);
    Optional<StoreEntity> findByStoreIdAndDeletedAt(Long id, LocalDateTime date);
    List<StoreEntity> findAllByDeletedAt(LocalDateTime date);
    Optional<StoreEntity> findByEmailAndDeletedAt(String email, LocalDateTime date);
}

