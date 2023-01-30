package com.diy.repository;

import com.diy.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAllByStoreIdAndDeletedAt(Long storeid, LocalDateTime date);
    Optional<CategoryEntity> findByCategoryIdAndDeletedAt(Long id, LocalDateTime date);
}

