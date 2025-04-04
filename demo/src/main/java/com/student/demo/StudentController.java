package com.student.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController (StudentService studentService){
        this.studentService = studentService;
    }



    @PostMapping
    public ResponseEntity<Student>
    createStudent(@RequestBody  Student student)
         {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
          }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student> >
    getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>>
    getAllStudents(){
      return  ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @DeleteMapping("/{id}")
    public void
    deleteStudentById(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student>

    updateStudentById(@PathVariable Long id,@RequestBody Student student ){
      return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(id,student));
    }

}