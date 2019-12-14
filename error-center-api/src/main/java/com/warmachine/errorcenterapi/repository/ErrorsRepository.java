package com.warmachine.errorcenterapi.repository;

import com.warmachine.errorcenterapi.entity.Error;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorsRepository extends JpaRepository<Error, Long> {
    
}
