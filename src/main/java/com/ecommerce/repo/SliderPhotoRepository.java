package com.ecommerce.repo;

import com.ecommerce.entity.SliderPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SliderPhotoRepository extends JpaRepository<SliderPhoto, Long> {
}
