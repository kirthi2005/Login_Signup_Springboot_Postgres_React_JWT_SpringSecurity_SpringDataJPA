package com.example.appointment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
//---------------------------------------------------------------------------------
// class level CORS configuration
//@CrossOrigin(origins = "http://localhost:5173/", methods = RequestMethod.POST)
//----------------------------------------------------------------------------------
@RestController
public class LoginController {
    /*@GetMapping("/login")
    public String getData(){
        return "Hello";
    }*/
    //--------------------------------------------------------------------------------
    // method level CORS configuration
    //@CrossOrigin(origins = "http://localhost:5173/", methods = RequestMethod.POST)
    //--------------------------------------------------------------------------------
    @PostMapping("/postData")
    @ResponseBody
    public String postData(@RequestBody String requestBody){
        System.out.println(requestBody);
        return "login successful";
        //return "body in post message"+ requestBody;
    }

}



