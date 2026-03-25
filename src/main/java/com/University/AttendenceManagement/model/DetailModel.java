package com.University.AttendenceManagement.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DetailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // ✅ primary key

    private String usn;        // ✅ changed to String
    private String subjectCode;
    private String name;

    private LocalDateTime dateTime;

    // ✅ Default constructor (REQUIRED)
    public DetailModel() {
    }

    // ✅ Optional constructor
    public DetailModel(String usn, String name, String subjectCode) {
        this.usn = usn;
        this.name = name;
        this.subjectCode = subjectCode;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}