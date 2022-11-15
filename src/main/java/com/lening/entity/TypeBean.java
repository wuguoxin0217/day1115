package com.lening.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_type")
public class TypeBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    private String tname;
    private Integer pid;
}
