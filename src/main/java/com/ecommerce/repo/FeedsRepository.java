package com.ecommerce.repo;

import com.ecommerce.entity.Feeds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedsRepository extends JpaRepository<Feeds, Long> {
}
