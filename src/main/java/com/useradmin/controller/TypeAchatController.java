package com.useradmin.controller;

import com.useradmin.models.OperationArticle;
import com.useradmin.models.TypeAchat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/types")
public class TypeAchatController {

    @GetMapping
    @RequestMapping("/all")
    public List<TypeAchat> getTypeAchat() {
        return Arrays.asList(TypeAchat.values());
    }
}



