package com.acerta.rest.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acerta.application.category.create.useCase.commands.create.CreateCategoryOutput;
import com.acerta.rest.models.request.create.CreateCategoryFlowRequest;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @PostMapping
    public ResponseEntity<CreateCategoryOutput> createCategory(@RequestBody CreateCategoryFlowRequest request) {
        // Código malicioso aqui
        


        var output = CreateCategoryOutput.with(UUID.randomUUID().toString());

        return new ResponseEntity<CreateCategoryOutput>(output, HttpStatus.OK);
    }
}
