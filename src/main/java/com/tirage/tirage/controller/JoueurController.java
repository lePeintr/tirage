package com.tirage.tirage.controller;

import com.tirage.tirage.metier.JoueurMetier;
import com.tirage.tirage.repository.modeles.Joueur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/tirage")
public class JoueurController {

   private final JoueurMetier joueurMetier;

    public JoueurController(JoueurMetier joueurMetier) {
        this.joueurMetier = joueurMetier;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Joueur>> getAllJoueur(@RequestBody Joueur joueur){
        List<Joueur> joueurs= joueurMetier.findAllJoueur();
        return new ResponseEntity<>(joueurs, HttpStatus.OK);
    }

    @GetMapping(path = "/find/{name}")
    public ResponseEntity<Joueur> getJoueurByName(@PathVariable("name") String name){
        Joueur joueur = joueurMetier.findJoueurByName(name);
        return new ResponseEntity<>(joueur, HttpStatus.OK);
    }

    @PostMapping(path = "/ajouter")
    public ResponseEntity<Joueur> addJoueur(@RequestBody Joueur joueur){
        Joueur newJoueur = joueurMetier.createJoueur(joueur);
    return new ResponseEntity<>(newJoueur, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteJoueurByName(@PathVariable("id") String id){
       joueurMetier.deleteJoueurById(Integer.valueOf(id));
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
