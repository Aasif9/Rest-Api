package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("/get_student")
    public Student addStudent(@RequestParam("q") int admnNo) {
        return studentService.getStudent(admnNo);
    }

    //add information
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("id") int id, @RequestParam int age) {
          return studentService.updateStudent(id,age);
    }

    //Delete information using Id :-->>
    @DeleteMapping("/delete_student{id}")
    public String deleteStudent(@PathVariable("id") int id) {
           return studentService.deleteStudent(id);
    }


}
