/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcf.efficienttrade.repository;

import com.gcf.efficienttrade.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gabriel
 */
public interface MatchRepository extends JpaRepository<Match, Long>{
    Match findById(long id);
}
