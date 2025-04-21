package com.ecommerce.repo;

import com.ecommerce.entity.Gharpatti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GharpattiRepository extends JpaRepository<Gharpatti, Long> {
}
