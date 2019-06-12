/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcf.efficienttrade.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "TB_PRODUTO")
@Setter
@Getter
public class Produto{
    @Id
    @Column(name = "produto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long produtoID = 0;
    @Column(name = "produto_name")
    private String produtoName = null;
    @Column(name = "disponivel")
    private boolean disponivel;
}
