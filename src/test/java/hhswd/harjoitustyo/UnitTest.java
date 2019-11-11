package hhswd.harjoitustyo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import hhswd.harjoitustyo.domain.Game;
import hhswd.harjoitustyo.domain.GameRepository;
import hhswd.harjoitustyo.domain.Genre;
import hhswd.harjoitustyo.domain.GenreRepository;
import hhswd.harjoitustyo.domain.User;
import hhswd.harjoitustyo.domain.UserRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitTest {
@Autowired
private GameRepository gameRepository;
@Autowired
private GenreRepository genreRepository;
@Autowired
private UserRepository userRepository;

@Test
public void createNewGame() {
	Game game = new Game("Budokai", 2000, new Genre("Shooter"));
	gameRepository.save(game);
	assertThat(game.getId()).isNotNull();
	
}
@Test
public void findByUserName() {
	User user = userRepository.findByUsername("admin");
	assertThat(user.getEmail()).isEqualTo("moi@gmail.com");
}
@Test
public void deleteAllUsers() {
	userRepository.deleteAll();
	assertThat(userRepository.count()).isEqualTo(0);
}
@Test
public void createNewGenre() {
	Genre genre = new Genre("Platformer");
	genreRepository.save(genre);
	assertThat(genre.getGenreid()).isNotNull();
	genreRepository.deleteById((long) 1);
	
}

}
