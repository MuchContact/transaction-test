package com.example.demo;

import com.example.demo.service.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
    @Autowired
    JpaService jpaService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//	    new Thread(() -> jpaService.rollback(System.getenv("unicode"), 1, Integer.parseInt(System.getenv("timeout")))).start();
        jpaService.transRollbackWhenInvokingInnerTransactionWhichThrowsException(jpaService);
    }
}
