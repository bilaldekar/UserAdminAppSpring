package com.useradmin.controller;


import com.useradmin.models.*;
import com.useradmin.repositories.FournisseurRepository;
import com.useradmin.repositories.OperationArticleRepository;
import com.useradmin.repositories.OperationServiceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/operations")
public class OperationController {

    @Autowired
    private OperationArticleRepository operationArticleRepository;
    @Autowired
    private OperationServiceRepository operationServiceRepository;

    @Autowired
    private FournisseurRepository  fournisseurRepository;

    @GetMapping
    @RequestMapping("/all")
    public List<OperationArticle> getOperationArticle() {
        return operationArticleRepository.findAll();
    }


    @GetMapping
    @RequestMapping("/one/{id}")
    public OperationArticle getOneOperationArticle(@PathVariable("id") Long id) {
        return operationArticleRepository.getOne(id);
    }


    @GetMapping
    @RequestMapping("/fournisseur")
    public List<Fournisseur> getFournisseur() {
        return fournisseurRepository.findAll();
    }

    @PostMapping("/article/save")
    public ResponseEntity<?> addOperation(@Valid @RequestBody OperationArticle operation, BindingResult result) {
        //  Un map pour gérer les erreurs
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Operation operations = operationArticleRepository.save(operation);
        return new ResponseEntity<Operation>(operations, HttpStatus.CREATED);
    }



    @PostMapping("/service/save")
    public ResponseEntity<?> addOperationService(@Valid @RequestBody OperationService operation, BindingResult result) {
        //  Un map pour gérer les erreurs
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Operation operations = operationServiceRepository.save(operation);
        return new ResponseEntity<Operation>(operations, HttpStatus.CREATED);
    }

    @PutMapping("/article/edit/{id}")
    public ResponseEntity<?> editOperation(@Valid @RequestBody OperationArticle operationArticle, @PathVariable("id") Long id, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        OperationArticle existingOp = operationArticleRepository.getOne(id);
        BeanUtils.copyProperties(operationArticle, existingOp, "id");
        OperationArticle operationList = operationArticleRepository.saveAndFlush(existingOp);
        return new ResponseEntity<OperationArticle>(operationList, HttpStatus.CREATED);
    }
}
