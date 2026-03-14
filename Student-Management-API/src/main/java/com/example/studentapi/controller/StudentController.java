package com.example.studentapi.controller;
import com.example.studentapi.model.Student;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentRepository repository;
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = repository.findById(id).orElseThrow();
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setCourse(studentDetails.getCourse());
        return repository.save(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
    }
}