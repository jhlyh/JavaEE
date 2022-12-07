package com.example.springmvc.repository;

import com.example.springmvc.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);
}
