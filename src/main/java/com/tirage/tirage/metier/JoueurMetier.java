package com.tirage.tirage.metier;

import com.tirage.tirage.repository.JoueurRepository;
import com.tirage.tirage.repository.modeles.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurMetier {

    @Autowired
    JoueurRepository joueurRepository;

    public Joueur createJoueur(Joueur joueur){
         return joueurRepository.save(joueur);
    }

    public List<Joueur> findAllJoueur(){
        return (List<Joueur>) joueurRepository.findAll();
    }

    public Joueur findJoueurByName(String name){
        return  joueurRepository.findByName(name);
    }

    public void deleteJoueurById(Integer id){
        joueurRepository.deleteById(id);
    }
}
