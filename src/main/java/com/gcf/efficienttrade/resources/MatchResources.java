/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcf.efficienttrade.resources;

import com.gcf.efficienttrade.models.Match;
import com.gcf.efficienttrade.repository.MatchRepository;
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
public class MatchResources {
    @Autowired
    MatchRepository matchRepository;

    @ApiOperation(value = "Retorna uma lista de matchs")
    @GetMapping("/match")
    public List<Match> listaMatchs() {
        return matchRepository.findAll();
    }

    @ApiOperation(value = "Retorna um match unico")
    @GetMapping("/match/{id}")
    public Match listaMatch(@PathVariable(value = "id") long id) {
        return matchRepository.findById(id);
    }

    @ApiOperation(value = "Salva um match")
    @PostMapping("/match/save")
    public Match save(@RequestBody @Valid Match cliente) {
        return matchRepository.save(cliente);
    }

    @ApiOperation(value = "Deleta um match")
    @DeleteMapping("/match/delete")
    public void deletaMatch(@RequestBody @Valid Match match) {
        matchRepository.delete(match);
    }

    @ApiOperation(value = "Atualiza um match")
    @PutMapping("/match/update")
    public Match atualizaMatch(@RequestBody @Valid Match match) {
        return matchRepository.save(match);
    }
}
