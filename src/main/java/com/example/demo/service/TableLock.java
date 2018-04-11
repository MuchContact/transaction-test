package com.example.demo.service;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "aaa")
public class TableLock {
    @Id
    @GeneratedValue(generator = "generator")
//    @SequenceGenerator(name = "generator")
    @GenericGenerator(name = "generator", strategy = "assigned")
    private int id;

    private String unicode;
}

