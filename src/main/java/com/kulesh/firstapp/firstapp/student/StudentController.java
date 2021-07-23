package com.kulesh.firstapp.firstapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<student> getStudents(){
return studentService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody student Student){
studentService.addNewStudent(Student);
    }
    @DeleteMapping(path = "{StudentId}")
    public void deleteStudent(@PathVariable("StudentId")Long StudentId){
studentService.deleteStudent(StudentId);
    }
    @PutMapping(path = "{StudentId}")
    public void updateStudent(@PathVariable("StudentId")Long StudentId,
                              @RequestParam(required = false)String name,
                              @RequestParam(required = false)String email){
        studentService.updateStudent(StudentId,name,email);

    }
}
