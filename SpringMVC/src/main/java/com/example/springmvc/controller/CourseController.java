package com.example.springmvc.controller;

import com.example.springmvc.model.Course;
import com.example.springmvc.model.Profession;
import com.example.springmvc.model.Type;
import com.example.springmvc.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
@Slf4j
public class CourseController {
    private final CourseRepository courseRepository;

    private CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("course", new Course());
        Type[] types = Type.values();
        model.addAttribute("type", types);
        Profession[] professions = Profession.values();
        model.addAttribute("prof", professions);
        return "course";
    }

    @PostMapping
    public String add(Course course) {
        log.info(course.toString());
        courseRepository.save(course);
        return "redirect:/";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Course> courseList = courseRepository.findAll();
        log.info(courseList.toString());
        model.addAttribute("courses", courseList);
        model.addAttribute("OneCourse", new Course());
        return "findAll";
    }

    @PostMapping("/findAll")
    public String find(Course OneCourse, Model model) {
        OneCourse = courseRepository.findByName(OneCourse.getName());
        model.addAttribute("course", OneCourse);
        return "detail";
    }
}
