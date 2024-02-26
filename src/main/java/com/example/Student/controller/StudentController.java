package com.example.Student.controller;

import com.example.Student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    Map<String, Student> mapIdToStudent = new HashMap<>();
    Map<String, List<Student>> mapUniversityToStudent = new HashMap<>();

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        String id = UUID.randomUUID().toString();
        student.setId(id);
        mapIdToStudent.put(id, student);
        
        mapUniversityToStudent.computeIfAbsent(student.getUniversity(), k -> new ArrayList<>()).add(student);
        
        return id;
    }

    @GetMapping("/getStudentsByUniversity")
    public List<Student> getAllStudentsByUniversity(@RequestParam String university){
        return mapUniversityToStudent.getOrDefault(university, new ArrayList<>());
    }

    @GetMapping("/getStudentById")
    public Student getStudentById(@RequestParam String id){
        return mapIdToStudent.getOrDefault(id, null);
    }
}
