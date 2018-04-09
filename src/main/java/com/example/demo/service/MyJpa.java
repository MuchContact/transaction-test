package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyJpa extends JpaRepository<TableLock, Integer>{
}
