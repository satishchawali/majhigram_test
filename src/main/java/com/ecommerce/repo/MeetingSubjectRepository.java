package com.ecommerce.repo;

import com.ecommerce.entity.MeetingSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingSubjectRepository extends JpaRepository<MeetingSubject, Long> {
}
