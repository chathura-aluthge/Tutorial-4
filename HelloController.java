package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * Week 1 controller.
 *   GET /hello    -> a simple greeting
 *   GET /goodbye  -> a simple farewell (Activity 3)
 *   GET /status   -> a status message with today's date
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello from Spring Boot!";
    }

    @GetMapping("/goodbye")
    public String goodbye(){
        return "Goodbye from Spring Boot!";
    }

    @GetMapping("/status")
    public String status(){
        return "API is running - today is " + LocalDate.now().toString();
    }

}
