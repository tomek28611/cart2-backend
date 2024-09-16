package com.shopcollection.shopcollection.repository;

import com.shopcollection.shopcollection.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByProductId(Long id);
}
