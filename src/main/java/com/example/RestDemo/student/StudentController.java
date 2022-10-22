package com.example.RestDemo.student;

import com.example.RestDemo.messages.ClientMessage;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
@RestController

//@Component
@RequestMapping(path ="api/v1/student/")
public class StudentController {
    // @GetMapping(value = "api/v1/student")
    //@RequestMapping(path ="api/v1/student")
    //@GetMapping
    //@DeleteMapping
    //List<String> st = new ArrayList<String>();
    // st[0]="f";

   // @RequestMapping(path = "api/v1/student1", method = RequestMethod.GET)
    @GetMapping("h")
    public List<Student> getAllItems() {
        //LocalDate localDate=;
        return List.of(new Student(1L, "peterayusi200@gmail.com", LocalDate.now(), "Ayusi", 12), new Student(1L, "peterayusi200@gmail.com", LocalDate.of(2000, Month.DECEMBER, 6), "Ayusi", 12), new Student(1L, "peterayusi200@gmail.com", LocalDate.of(2000, Month.DECEMBER, 6), "Ayusi", 12));
        //System.out.println("Hello world");

    }

    @DeleteMapping(path ="posty/{id}")
    public String postName(@PathVariable("id") String id) {
        //LocalDate localDate=;
        //return List.of(new Student(1L, "peterayusi200@gmail.com", LocalDate.now(), "Ayusi", 12), new Student(1L, "peterayusi200@gmail.com", LocalDate.of(2000, Month.DECEMBER, 6), "Ayusi", 12), new Student(1L, "peterayusi200@gmail.com", LocalDate.of(2000, Month.DECEMBER, 6), "Ayusi", 12));
        //System.out.println("Hello world");
        return "Go home";
    }
        // @GetMapping(value = "api/v1/greetings")
    //@GetMapping

   // @RequestMapping(path= "api/v1/student/{email}", method = RequestMethod.GET)

    @GetMapping(path="studentemail")
    public ResponseEntity<List<Student>> findStudent(@RequestParam("email") String email) {

         if(email.isEmpty())
         {
             return ResponseEntity.status(HttpStatus.OK).body(List.of());
         }
         else {
             Student student1 = new Student(1L, "", LocalDate.now(), "Ayusi", 12);
             student1.setEmail(email);

             Student stud2 = new Student(1L, "etamos@gmail.com", LocalDate.now(), "Ayusi", 12);
             return ResponseEntity.status(HttpStatus.OK).body(List.of(student1, stud2));
         }

}

/*
    @GetMapping(value="/registerstudent")// Illustration using @RequestParam


    public ResponseEntity<ClientMessage> createStudent(@RequestParam(required = true,value = "name") String name)
    {
        if(name.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ClientMessage("error","Name cannot be empty"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClientMessage("success","Student created successfully"));
    }
*/
  //
    @GetMapping(value="/registerstudent/{name}")

    public ResponseEntity<ClientMessage> createStudent(@PathVariable("name") String name)
    {


            if(name.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ClientMessage("error","Name cannot be empty"));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(new ClientMessage("success","Student created successfully"));

    }




}
