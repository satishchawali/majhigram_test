package com.ecommerce.repo;

import com.ecommerce.entity.GsfMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GsfMembersRepository extends JpaRepository<GsfMembers, Long> {
}
