package com.diy.repository;

import com.diy.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByStoreIdAndDeletedAt(Long storeid, LocalDateTime date);
    Optional<ProductEntity> findByProductIdAndDeletedAt(Long id, LocalDateTime date);

}
