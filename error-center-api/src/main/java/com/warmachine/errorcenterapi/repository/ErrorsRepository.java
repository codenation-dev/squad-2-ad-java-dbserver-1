package com.warmachine.errorcenterapi.repository;

import com.warmachine.errorcenterapi.entity.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorsRepository extends JpaRepository <ErrorLog, Long> {
    
}
