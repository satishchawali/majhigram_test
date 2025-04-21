package com.ecommerce.repo;

import com.ecommerce.entity.Graminfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraminfoRepository extends JpaRepository<Graminfo, Long> {
}
