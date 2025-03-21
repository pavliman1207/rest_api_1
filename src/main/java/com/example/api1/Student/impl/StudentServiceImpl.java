package com.example.api1.Student.impl;

import com.example.api1.Student.Student;
import com.example.api1.Student.StudentRepository;
import com.example.api1.Student.StudentService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @CacheEvict(value = "allStudents", allEntries = true)
    @Override
    public List<Student> findAll() throws InterruptedException {
        Thread.sleep(2000);
        return studentRepository.findAll();
    }
    @CacheEvict(value = "allStudents", allEntries = true)
    @Override
    public void createStudent(Student student)  {

        studentRepository.save(student);

    }
    @Cacheable(value = "students", key = "#id")
    @Override
    public Student getStudentById(int id) throws InterruptedException {
        Thread.sleep(2000);
        return studentRepository.findById(id).orElse(null);
    }


    @Override
    public boolean deleteStudentById(int id)  {

       try {
           if (studentRepository.existsById(id)) {
               studentRepository.deleteById(id);
               studentRepository.flush();
               System.out.println("Студент с id " + id + " удален");
               return true;
           } else {
               return false;
           }
       } catch (Exception e) {
           System.out.println("ошибка при удаление"+e.getMessage());
           return false;
       }

    }
    @Caching(
            evict = {@CacheEvict(value = "allStudents", allEntries = true),
                    @CacheEvict(value = "students", key = "#id")},
            put = {@CachePut(value = "students", key = "#id")}
    )
    @Override
    public boolean updateStudentFam(int id, String fam)  {

        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setFam(fam);
            try {
                studentRepository.save(student);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}











