package com.ecommerce.repo;

import com.ecommerce.entity.Meetingplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingplaceRepository extends JpaRepository<Meetingplace, Long> {
}
