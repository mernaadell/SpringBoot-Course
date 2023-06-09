package com.javalearning.restapi.Controllers;


import com.javalearning.restapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    //use generic class to return http response
    @GetMapping("/student") //map request to this method

    public ResponseEntity<Student> getStudent(){

        Student s = new Student('8',"merna","adel");
        System.out.println(s);
       // return new ResponseEntity<>(s,HttpStatus.OK); //parse java bean object to json
        return ResponseEntity.ok()
                .header("auth","merna")
                .body(s);
    }

    @GetMapping("/")
    public List<Student> getStudents(){

        List<Student> Students =new ArrayList<>();

        Students.add(new Student(2,"mayar","adel"));
        Students.add(new Student(3,"yehia","elsayed"));

        return Students; //parse java bean object list to json array

    }

    @GetMapping("/{id}/{firstName}/{last-Name}")
    public Student addStudent(@PathVariable int id,@PathVariable String firstName, @PathVariable("last-Name") String lastName){ //bind path variable to request

        Student s = new Student(id,firstName,lastName);

        return s;
    }
    @GetMapping("/params")
    public Student addStudentrequestParams(@RequestParam int id){ //extract value id from uri

        Student s = new Student(id,"merna","adel");

        return s;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){  //convert json to java bean object both are the same name
        Student s = new Student(student.getId(),student.getFirstName(),student.getLastName());
        return s;
    }
    @PutMapping("/student/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable int id){  //convert json to java bean object both are the same name
        System.out.println(student.getFirstName());
        return student;
    }
    @DeleteMapping("/{id}/delete")
    public String deleteStudent(@PathVariable int id){  //convert json to java bean object both are the same name
        System.out.println(id);
        return "deleted";
    }
}
