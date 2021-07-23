package com.kulesh.firstapp.firstapp.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<student,Long> {
    Optional<student> findStudentByEmail(String email);
//    @Query("SELECT s FROM student s WHERE s.email=?1")
    //Optional<student> findstudentByEmail(String email);
}
