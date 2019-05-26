/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcf.efficienttrade.resources;

import com.gcf.efficienttrade.models.Cliente;
import com.gcf.efficienttrade.repository.ClienteRepository;
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
public class ClienteResources {
    @Autowired
    ClienteRepository clienteRepository;

    @ApiOperation(value = "Retorna uma lista de clientes")
    @GetMapping("/cliente")
    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    @ApiOperation(value = "Retorna um cliente unico")
    @GetMapping("/cliente/{id}")
    public Cliente listaCliente(@PathVariable(value = "id") long id) {
        return clienteRepository.findById(id);
    }

    @ApiOperation(value = "Salva um cliente")
    @PostMapping("/cliente/save")
    public Cliente save(@RequestBody @Valid Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @ApiOperation(value = "Deleta um cliente")
    @DeleteMapping("/cliente/delete")
    public void deletaCliente(@RequestBody @Valid Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @ApiOperation(value = "Atualiza um cliente")
    @PutMapping("/cliente/update")
    public Cliente atualizaCliente(@RequestBody @Valid Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
}
