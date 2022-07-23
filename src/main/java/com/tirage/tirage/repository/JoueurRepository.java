package com.tirage.tirage.repository;

import com.tirage.tirage.repository.modeles.Joueur;
import org.springframework.data.repository.CrudRepository;


public interface JoueurRepository extends CrudRepository<Joueur,Integer> {
Joueur findByName(String name);


}
