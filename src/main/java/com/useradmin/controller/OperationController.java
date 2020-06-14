package com.useradmin.controller;


import com.useradmin.models.Operation;
import com.useradmin.models.OperationArticle;
import com.useradmin.models.Users;
import com.useradmin.repositories.OperationArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/operations")
public class OperationController {


    @Autowired
    private OperationArticleRepository operationArticleRepository;



    @GetMapping
    @RequestMapping("/article")
    public List<OperationArticle> getOperationArticle() {
        return operationArticleRepository.findAll();
    }
}
