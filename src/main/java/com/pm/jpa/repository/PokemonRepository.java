package com.pm.jpa.repository;

import com.pm.jpa.model.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Page<Pokemon> findByPlayerId(Long playerId, Pageable pageable);
    Optional<Pokemon> findByIdAndPlayerId(Long id, Long playerId);
}
