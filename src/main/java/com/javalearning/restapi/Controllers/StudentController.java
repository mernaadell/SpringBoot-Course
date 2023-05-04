package com.javalearning.restapi.Controllers;


import com.javalearning.restapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student") //map request to this method

    public Student getStudent(){

        Student s = new Student('1',"merna","adel");

        return s; //parse java bean object to json
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> Students =new ArrayList<>();

        Students.add(new Student(2,"mayar","adel"));
        Students.add(new Student(3,"yehia","elsayed"));

        return Students; //parse java bean object list to json array

    }
}
