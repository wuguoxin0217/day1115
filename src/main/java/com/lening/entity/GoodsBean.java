package com.lening.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_goods")
public class GoodsBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    private String gname;
    private Double gprice;
    private Integer tid;

    private TypeBean typeBean;
}
