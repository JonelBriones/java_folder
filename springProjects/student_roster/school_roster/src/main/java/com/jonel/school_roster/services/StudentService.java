//package com.jonel.school_roster.services;
//
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//import com.jonel.school_roster.models.Student;
//import com.jonel.school_roster.repositories.StudentRepository;
//
//
//@Service
//public class StudentService {
// // adding the book repository as a dependency
//	private final StudentRepository studentRepository;
// 
// public StudentService(StudentRepository studentRepository) {
//	 this.studentRepository = studentRepository;
// }
// // returns all the books
// public List<Student> all() {
//     return studentRepository.findAll();
// }
// // creates a book
// public Student create(Student b) {
//     return studentRepository.save(b);
// }
//
//// update a book
// public Student update(Student b) {
//     return studentRepository.save(b);
// }
//
// // retrieves a book by id
// public Student findId(Long id) {
//     Optional<Student> optionalStudent = studentRepository.findById(id);
//     if(optionalStudent.isPresent()) {
//         return optionalStudent.get();
//     } else {
//         return null;
//     }
// }
//// deletes a book
//  public void delete(Long id) {
//	  studentRepository.deleteById(id);
//  }
//
//}