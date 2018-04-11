package com.example.demo.service;

import com.example.demo.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.TimeUnit;

@Service
public class JpaService {
    @Autowired
    MyJpa myJpa;


    @Transactional
    public void rollback(String unicode, int id, int timeout) {
        TableLock tl = new TableLock();
        tl.setId(id);
        tl.setUnicode(unicode);
        myJpa.save(tl);
//        myJpa.flush();
        try {
            System.out.println(Thread.currentThread().getName() + "before commit");
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void insert() {
        TableLock tl = new TableLock();
        tl.setUnicode("abdc");
        myJpa.save(tl);
        myJpa.flush();
    }


    @Transactional
    public void transRollbackWhenInvokingInnerTransactionWhichThrowsException(JpaService jpaService) {
        try {
            ReflectUtils.getMethodValue(jpaService, "innerTransWithReflection");
//            try{
//                innerTransWithReflection();
//            } catch (Exception exc) {
//                System.out.println("AAAAAAAAAAAAAAAAAAAAA");
//                exc.printStackTrace();
//            }
            TableLock tl = new TableLock();
            tl.setId(100);
            myJpa.save(tl);
        } catch (Exception e) {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");
            e.printStackTrace();
        }
    }

    @Transactional
    public void innerTransWithReflection() {
        throw new RuntimeException("看不到的异常");
    }
}
