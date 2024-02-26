package com.example.Student.controller;

import com.example.Student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {

    Map<String, Student> mapIdToStudent;

    Map<String, List<Student>> mapUniversityToStudent;

    @PostMapping("/addStudent")
    public String addStudent(@RequesBody String name,
    @RequesBody int age,
    @RequesBody String adhar,
    @RequesBody String university){
        String id = UUID.randomUUID().toString();
        Student students = new Student(id, name, age, adhar, university);
        mapIdToStudent.put(university, students);
        return id;
    }

    @GetMapping("/getStudentByUniversity")
    public List<Student> getAllStudentsByUniversity(String university){
        return mapUniversityToStudent.getOrDefault(university, null);
    }

    @GetMapping("/getStudentById")
    public Student getStudentById(String id){
        return mapIdToStudent.getOrDefault(id, null);
    }
}
