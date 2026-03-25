package com.University.AttendenceManagement.DetailService;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.University.AttendenceManagement.DetailsRepository.DetailRepo;
import com.University.AttendenceManagement.model.DetailModel;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

class DateTime {

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}


@Service
public class DetailService {

    @Autowired
    DetailRepo repo;

    public String setDetails(String name, String usn, String subCode) {

        // ✅ Define today's start and end time
        LocalDate today = LocalDate.now();

        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(23, 59, 59);

        // ✅ Check if already exists
        boolean alreadyMarked = repo
                .findByUsnAndSubjectCodeAndDateTimeBetween(usn, subCode, startOfDay, endOfDay)
                .isPresent();

        if (alreadyMarked) {
            return "Attendance already marked for today!";
        }

        // ✅ Save new entry
        DetailModel student = new DetailModel();
        student.setName(name);
        student.setUsn(usn);
        student.setSubjectCode(subCode);
        student.setDateTime(LocalDateTime.now());

        repo.save(student);

        return "Attendance marked successfully!";
    }
}
