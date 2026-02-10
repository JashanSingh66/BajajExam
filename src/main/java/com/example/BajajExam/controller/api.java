package com.example.BajajExam.controller;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.BajajExam.service.serviceApi;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class api {
     private final serviceApi service;

    public api(serviceApi service){
        this.service = service;
    }
    @PostMapping("/bfhl")
    public ResponseEntity<?> getBFHL(@RequestBody Map<String,Object> body){

        Object result=service.process(body);

        LinkedHashMap<String,Object> response=new LinkedHashMap<>();
        response.put("is_success",true);
        response.put("official_email","jashan0698.be23@chitkara.edu.in");
        response.put("data",result);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/health")
    public ResponseEntity<?> getHealth() {
        LinkedHashMap<String,Object> response=new LinkedHashMap<>();
        response.put("is_success",true);
        response.put("official_email","jashan0698.be23@chitkara.edu.in");
        return ResponseEntity.ok(response);
    }
}
