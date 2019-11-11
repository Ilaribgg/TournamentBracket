package hhswd.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
List<Player> findByPlayername(String playername);
List<Player> findByGameId(Long id);
}
