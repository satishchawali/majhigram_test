package com.ecommerce.repo;

import com.ecommerce.entity.Panipatti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanipattiRepository extends JpaRepository<Panipatti, Long> {
}
