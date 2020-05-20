package com.pm.jpa.repository;

import com.pm.jpa.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query(value="SELECT count(*),b.name,b.level FROM players a, pokemons b WHERE a.id=:playerId and b.player_id=:playerId group by b.name,b.level order by b.name", nativeQuery=true)
    List<?> getPokemonSummary(@PathVariable (value = "playerId") Long playerId);
}
