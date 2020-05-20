package com.pm.jpa.controller;

import com.pm.jpa.exception.ResourceNotFoundException;
import com.pm.jpa.model.Player;
import com.pm.jpa.model.Pokemon;
import com.pm.jpa.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players")
    public Page<Player> getAllPlayers(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }
    
    @GetMapping("/players/{playerId}/pokemonsummary")
    public List<?> getAllPokemonsByPlayerId(@PathVariable (value = "playerId") Long playerId) {
        return playerRepository.getPokemonSummary(playerId);
    }     

    @PostMapping("/players")
    public Player createPlayer(@Valid @RequestBody Player player) {
        return playerRepository.save(player);
    }   

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable Long playerId, @Valid @RequestBody Player playerRequest) {
        return playerRepository.findById(playerId).map(player -> {
            player.setName(playerRequest.getName());
            return playerRepository.save(player);
        }).orElseThrow(() -> new ResourceNotFoundException("PlayerId " + playerId + " not found"));
    }

    @DeleteMapping("/players/{playerId}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long playerId) {
        return playerRepository.findById(playerId).map(player -> {
            playerRepository.delete(player);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PlayerId " + playerId + " not found"));
    }

}
