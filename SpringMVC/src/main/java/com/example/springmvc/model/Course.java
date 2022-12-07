package com.example.springmvc.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    //课程名字
    private String name;
    //课程描述
    private String info;
    //授课时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
    //人数
    private Integer num;
    //教室
    private String classroom;
    //专业
    @Enumerated(EnumType.STRING)
    private Profession profession;
    //授课方式
    @Enumerated(EnumType.STRING)
    private Type type;
}
