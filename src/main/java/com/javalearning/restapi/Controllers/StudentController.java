package com.javalearning.restapi.Controllers;


import com.javalearning.restapi.bean.Student;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/student/{id}/{firstName}/{last-Name}")
    public Student addStudent(@PathVariable int id,@PathVariable String firstName, @PathVariable("last-Name") String lastName){ //bind path variable to request

        Student s = new Student(id,firstName,lastName);

        return s;
    }
    @GetMapping("/student/params")
    public Student addStudentrequestParams(@RequestParam int id){ //extract value id from uri

        Student s = new Student(id,"merna","adel");

        return s;
    }

    @PostMapping("/student/create")
    public Student createStudent(@RequestBody Student student){  //convert json to java bean object both are the same name
        Student s = new Student(student.getId(),student.getFirstName(),student.getLastName());
        return s;
    }
}
