package com.gg.bankingaapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gg.bankingaapp.model.Logger;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long> {

}
