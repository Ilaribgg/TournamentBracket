package hhswd.harjoitustyo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hhswd.harjoitustyo.domain.Game;
import hhswd.harjoitustyo.domain.GameRepository;
import hhswd.harjoitustyo.domain.Genre;
import hhswd.harjoitustyo.domain.GenreRepository;
import hhswd.harjoitustyo.domain.UserRepository;
import hhswd.harjoitustyo.domain.User;
import hhswd.harjoitustyo.domain.PlayerRepository;
import hhswd.harjoitustyo.domain.Player;

@SpringBootApplication
public class HarjoitustyoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}

@Bean
public CommandLineRunner gameDemo(GameRepository gameRepository, UserRepository uRepository, GenreRepository gRepository, PlayerRepository playerRepository) {
return (args) -> {
	log.info("Save a couple of games");
	
	gRepository.save(new Genre("Fighter"));
	gRepository.save(new Genre("FPS"));
	gRepository.save(new Genre("Sports"));
	gRepository.save(new Genre("Platformer"));
	gRepository.save(new Genre("Speedrunning"));
	gRepository.save(new Genre("MOBA"));
	
	gameRepository.save(new Game( "Dragonball FighterZ", 2017, gRepository.findByGenrename("Fighter").get(0)));
	gameRepository.save(new Game("Tekken 7", 2013, gRepository.findByGenrename("Fighter").get(0)));
	gameRepository.save(new Game("Guilty Gear XX Midnight Carnival Rev 2", 2000, gRepository.findByGenrename("Fighter").get(0)));
	
	
	
	User user1 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "moi@gmail.com");
	uRepository.save(user1);
	User user2 = new User("Stressboy", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "USER", "moi1@gmail.com");
	uRepository.save(user2);
	User user3 = new User("Mody", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "USER", "moi2@gmail.com");
	uRepository.save(user3);
	User user4 = new User("Samo", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "USER", "moi3@gmail.com");
	uRepository.save(user4);
	
	log.info("Get all games");
	for(Game game : gameRepository.findAll()) {
		log.info(game.toString());
	}
};
}
}

