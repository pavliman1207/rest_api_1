package com.example.api1.Student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Tag(name="Студенты",description = "API для работы со студентами")
@RestController
public class StudentConrtoller {
    private StudentService studentService;

    public StudentConrtoller(StudentService studentService) {
        this.studentService = studentService;
    }
@Operation(summary = "Получить список всех студентов",description = "возвращает всех студентов в систему")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "успешно получен список студентов"),
        @ApiResponse(responseCode = "400", description = "ошибка валидации"),
        @ApiResponse(responseCode = "500", description = "внутренняя ошибка сервера")
})
    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() throws InterruptedException {
        return ResponseEntity.ok(studentService.findAll());
    }

    @Operation(summary = "Создать студента",description = "добавляет нового студента")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201",description = "успешно добавлен студент"),
            @ApiResponse(responseCode = "500",description = "не успешно(студент не добавлен")
    })
    @PostMapping(value = "/students")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        try {
            studentService.createStudent(student);
            return new ResponseEntity<>("Студент добавлен", HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Ошибка" + e.getMessage());
            return new ResponseEntity<>("ошибка", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @Operation(summary = "получить студента по Id",description = "возвращает студента по его id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "успешно найден  студент"),
            @ApiResponse(responseCode = "404",description = "студент не найдет по данному id")
    })
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) throws InterruptedException {

        Student student = studentService.getStudentById(id);
        if (student != null)
            return new ResponseEntity<>(student, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Operation(summary = "изменить фамилию студента по Id",description = "изменяет фамилию студента по его id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "фамилия успешно изменена"),
            @ApiResponse(responseCode = "404",description = "студент не найдет по данному id")
    })
    @PatchMapping("/students/{id}")
    public ResponseEntity<String> updateStudentFam(@PathVariable int id,
                                                   @RequestBody String fam) throws InterruptedException {
        boolean update = studentService.updateStudentFam(id, fam);
        if (update) {
            return new ResponseEntity<>("Фамилия изменена", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Operation(summary = "удалить студента из системы по его id",description = "удаляет студента по его id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "успешно удален  студент"),
            @ApiResponse(responseCode = "404",description = "студент не найдет по данному id и не может быть удален")
    })
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent( @PathVariable int id) throws InterruptedException {
        boolean delete = studentService.deleteStudentById(id);
        if (delete){
            return new ResponseEntity<>("студент удален", HttpStatus.OK);}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}





