package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer,Student> db=new HashMap<>();

    public Student getStudent(int id){
        return db.get(id);
    }

    public String addStudent(Student student){
        int id = student.getAdmnNo();
        db.put(id,student);
        return "Student added successfully";
    }
    public String updateStudent( int id,int age) {
        if ( !db.containsKey(id)){
            return "Invalid Id" ;
        }
        Student student=db.get(id);
        student.setAge(age);

        // we can also write
       // db.get(id).setAge(20);
        return "Age updated successfully";
    }

    public String deleteStudent (int id ){
        if ( ! db.containsKey(id)){
            return "Admission number is invalid!!" ;
        } else {
            db.remove(id) ;
            return "Successfully remove from HashMap " ;
        }
    }
}
