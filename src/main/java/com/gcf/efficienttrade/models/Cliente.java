/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcf.efficienttrade.models;

/**
 *
 * @author Gabriel
 */
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TB_CLIENTE")
@Setter
@Getter
public class Cliente{
    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long clienteID;
    
    @Column(name = "client_name")
    private String clienteName = null;
 
    @Column(name = "ofertados")
    @OneToMany
    @JoinTable
    (
        name="Cliente_Ofertados",
        joinColumns={ @JoinColumn(name="cliente_id", referencedColumnName="cliente_id") },
        inverseJoinColumns={ @JoinColumn(name="ofertado_id", referencedColumnName="produto_id") }
    )
    private List<Produto> produtosOfertados;

    @Column(name = "desejados")
    @OneToMany
    @JoinTable
    (
        name="Cliente_Desejados",
        joinColumns={ @JoinColumn(name="cliente_id", referencedColumnName="cliente_id") },
        inverseJoinColumns={ @JoinColumn(name="desejado_id", referencedColumnName="produto_id") }
    )
    private List<Produto> produtosDesejados;
}
