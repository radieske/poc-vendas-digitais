package com.acerta.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acerta.rest.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

@RestController
public class UserController {
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserDTO request) throws JsonProcessingException  {
        System.out.println(request);

        ObjectMapper objectMapper = new ObjectMapper();
        var validationJSON = objectMapper.writeValueAsString(request);
        
        return ResponseEntity.ok(validationJSON);
    }
}
