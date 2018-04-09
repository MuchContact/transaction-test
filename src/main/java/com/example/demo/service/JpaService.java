package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class JpaService {
    @Autowired
    MyJpa myJpa;


    @Transactional
    public void rollback() {
        myJpa.deleteAll();
        myJpa.flush();
        TableLock tl = new TableLock();
        tl.setUnicode("abd");
        myJpa.save(tl);
        insert();
    }

    @Transactional
    public void insert() {
        TableLock tl = new TableLock();
        tl.setUnicode("abdc");
        myJpa.save(tl);
        myJpa.flush();
    }
}
