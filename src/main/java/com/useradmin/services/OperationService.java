package com.useradmin.services;

import com.useradmin.repositories.OperationArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OperationService {

    @Autowired
    private OperationArticleRepository operationArticleRepository;


}
