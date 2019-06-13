/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcf.efficienttrade.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name="TB_MATCH")
@Setter
@Getter
public class Match{
    @Id
    @Column(name = "match_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long matchID;
    
    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="cliente1", unique= true, nullable=true, insertable=true, updatable=true)
    private Cliente cliente1;
    
    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="produto1", unique= true, nullable=true, insertable=true, updatable=true)
    private Produto produto1;
    
    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="cliente2", unique= true, nullable=true, insertable=true, updatable=true)
    private Cliente cliente2;
    
    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="produto2", unique= true, nullable=true, insertable=true, updatable=true)
    private Produto produto2;
    
    @Column(name = "match_status")
    private boolean matchStatus;
/*
    public static void criaMatch() {
        for (Cliente cliente : getClientes()) {
            for (Produto produto : getProdutos()) {
                for (int i = 0; i < cliente.getProdutosDesejados().size(); i++) {

                    if (cliente.getProdutosDesejados().get(i) != produto
                            && cliente.getProdutosDesejados().get(i).name == produto.name
                            && produto.getDisponibilidade()
                            && cliente.getProdutosDesejados().get(i).getDisponibilidade()) {

                        Cliente cliente2 = getClientes().get(produto.getClienteID());
                        for (Produto produto2 : cliente.getProdutosOfertados()) {
                            if (cliente2.getProdutosDesejados().get(i) != produto2
                                    && cliente2.getProdutosDesejados().get(i).name == produto2.name
                                    && produto2.getDisponibilidade()
                                    && cliente2.getProdutosDesejados().get(i).getDisponibilidade()) {

                                Match m = new Match(produto.getClienteID(), cliente.getID(), produto, cliente.getProdutosDesejados().get(i));
                                produto.status = false;
                                produto2.status = false;

                                getTrocas().add(m);
                            }
                        }
                    }
                }
            }
        }
    }
*/
}
