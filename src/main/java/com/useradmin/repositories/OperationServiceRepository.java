package com.useradmin.repositories;

import com.useradmin.models.OperationArticle;
import com.useradmin.models.OperationService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationServiceRepository  extends JpaRepository<OperationService, Long> {

}
