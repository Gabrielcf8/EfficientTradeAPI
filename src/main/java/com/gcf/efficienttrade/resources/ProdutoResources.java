/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcf.efficienttrade.resources;

import com.gcf.efficienttrade.models.Produto;
import com.gcf.efficienttrade.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gabriel
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Efficient Trade")
public class ProdutoResources {

    @Autowired
    ProdutoRepository produtoRepository;

    @ApiOperation(value = "Retorna uma lista de produtos")
    @GetMapping("/produto")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @ApiOperation(value = "Retorna um produto unico")
    @GetMapping("/produto/{id}")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }

    @ApiOperation(value = "Salva um produto")
    @PostMapping("/produto/save")
    public Produto save(@RequestBody @Valid Produto Produto) {
        return produtoRepository.save(Produto);
    }

    @ApiOperation(value = "Deleta um produto")
    @DeleteMapping("/produto/delete")
    public void deletaProduto(@RequestBody @Valid Produto produto) {
        produtoRepository.delete(produto);
    }

    @ApiOperation(value = "Atualiza um produto")
    @PutMapping("/produto/update")
    public Produto atualizaProduto(@RequestBody @Valid Produto produto) {
        return produtoRepository.save(produto);
    }
}
