package com.useradmin.repositories;

import com.useradmin.models.Operation;
import com.useradmin.models.OperationArticle;
import com.useradmin.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationArticleRepository   extends JpaRepository<OperationArticle , Long> {


}
