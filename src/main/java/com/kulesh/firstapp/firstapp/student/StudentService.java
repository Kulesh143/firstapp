package com.kulesh.firstapp.firstapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
@Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(student Student) {
    Optional<student>studentOptional=studentRepository.findStudentByEmail(Student.getEmail());
    if(studentOptional.isPresent()){
        throw new IllegalStateException("email taken");
    }
    studentRepository.save(Student);
    System.out.println(Student);
    }

    public void deleteStudent(Long StudentId) {
    boolean exist=studentRepository.existsById(StudentId);
if(!exist){
    throw new IllegalStateException("student with id "+StudentId+" does not exist");
}
studentRepository.deleteById(StudentId);
    }
@Transactional
    public void updateStudent(Long studentId, String name, String email) {
    student Student=studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("student with id "+studentId+" does not exist"));
    if(name!=null&&name.length()>0&&!Objects.equals(Student.getName(),name)){
        Student.setName(name);
    }
    if(email!=null&&email.length()>0&&!Objects.equals(Student.getEmail(),email)){
        Optional<student>studentOptional=studentRepository.findStudentByEmail(email);
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        Student.setEmail(email);
    }

    }
}
