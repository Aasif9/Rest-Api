package com.avengers.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class StudentController {
    //This line of code creates a new HashMap object in Java called "db" that
    // stores key-value pairs where the keys are integers and the values are
    // objects of type "Student".The <Integer,Student> is a type parameter that
    // specifies the types of the keys and values in the HashMap. In this case,
    // the keys are of type Integer and the values are of type Student.
    HashMap<Integer,Student> db=new HashMap<>();
    //key will be the admission number coz we add student based on admnNo
    // we use student because we have to store entire student data

    //get information
    //return type will be student coz it will return a student object

    @GetMapping("/get_student")
    public Student addStudent(@RequestParam("q") int admnNo){
        return db.get(admnNo);
    }

    //add information
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student){
        int admnNo = student.getAdmnNo();
        db.put(admnNo,student);
        return "Student added successfully";
    }

    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("id") int id, @RequestParam int age) {
        if ( !db.containsKey(id)){
         //   System.out.println("The admission Number that you have entered does not exist");
            return "Invalid Id" ;
        }
        Student student=db.get(id);
        student.setAge(age);
        db.put(id,student);

        return "Age updated successfully";
    }

    //Delete information using Id :-->>
    @DeleteMapping("/delete_student")
    public String deleteStudent ( @PathVariable("id") int id ){
        if ( ! db.containsKey(id)){
            return "Admission number is invalid!!" ;
        } else {
            db.remove(id) ;
            return "Successfully remove from HashMap " ;
        }
    }

    @GetMapping("/get_student_by_name")
    public Student getStudentByName(@RequestParam("name") String name) {
        // Iterate over all the students in the database
        for (Student student : db.values()) {
            // Check if the student's name matches the given name
            if (student.getName().equalsIgnoreCase(name)) {
                // Return the student's information
                return student;
            }
        }
        // If no student with the given name is found, return null
        return null;
    }
}
