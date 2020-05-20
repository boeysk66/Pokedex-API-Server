package com.pm.jpa.controller;

import com.pm.jpa.exception.ResourceNotFoundException;
import com.pm.jpa.model.Pokemon;
import com.pm.jpa.repository.PokemonRepository;
import com.pm.jpa.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players/{playerId}/pokemons")
    public Page<Pokemon> getAllPokemonsByPlayerId(@PathVariable (value = "playerId") Long playerId,
                                                Pageable pageable) {
        return pokemonRepository.findByPlayerId(playerId, pageable);
    }

    @PostMapping("/players/{playerId}/pokemons")
    public Pokemon createPokemon(@PathVariable (value = "playerId") Long playerId,
                                 @Valid @RequestBody Pokemon pokemon) {
        return playerRepository.findById(playerId).map(player -> {
        	pokemon.setPlayer(player);
            return pokemonRepository.save(pokemon);
        }).orElseThrow(() -> new ResourceNotFoundException("PlayerId " + playerId + " not found"));
    }

    @PutMapping("/players/{playerId}/pokemons/{pokemonId}")
    public Pokemon updatePokemon(@PathVariable (value = "playerId") Long playerId,
                                 @PathVariable (value = "pokemonId") Long pokemonId,
                                 @Valid @RequestBody Pokemon pokemonRequest) {
        if(!playerRepository.existsById(playerId)) {
            throw new ResourceNotFoundException("PlayerId " + playerId + " not found");
        }

        return pokemonRepository.findById(pokemonId).map(pokemon -> {
        	pokemon.setName(pokemonRequest.getName());
        	pokemon.setLevel(pokemonRequest.getLevel());
            return pokemonRepository.save(pokemon);
        }).orElseThrow(() -> new ResourceNotFoundException("PokemonId " + pokemonId + "not found"));
    }

    @DeleteMapping("/players/{playerId}/pokemons/{pokemonId}")
    public ResponseEntity<?> deletePokemon(@PathVariable (value = "playerId") Long playerId,
                              @PathVariable (value = "pokemonId") Long pokemonId) {
        return pokemonRepository.findByIdAndPlayerId(pokemonId, playerId).map(pokemon -> {
            pokemonRepository.delete(pokemon);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Pokemon not found with id " + pokemonId + " and playerId " + playerId));
    }
}
