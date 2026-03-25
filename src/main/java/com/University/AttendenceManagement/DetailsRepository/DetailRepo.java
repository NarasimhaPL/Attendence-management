package com.University.AttendenceManagement.DetailsRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.University.AttendenceManagement.model.DetailModel;

@Repository
public interface DetailRepo extends JpaRepository<DetailModel,Integer> {
	 Optional<DetailModel> findByUsnAndSubjectCodeAndDateTimeBetween(
	            String usn,
	            String subjectCode,
	            LocalDateTime start,
	            LocalDateTime end
	    );
}
