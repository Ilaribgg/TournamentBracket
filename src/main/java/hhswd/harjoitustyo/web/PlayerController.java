package hhswd.harjoitustyo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hhswd.harjoitustyo.domain.Game;
import hhswd.harjoitustyo.domain.GameRepository;
import hhswd.harjoitustyo.domain.GenreRepository;
import hhswd.harjoitustyo.domain.Player;
import hhswd.harjoitustyo.domain.PlayerRepository;
import hhswd.harjoitustyo.domain.User;
import hhswd.harjoitustyo.domain.UserRepository;




@Controller
public class PlayerController {
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	GenreRepository gRepository;
	
	@Autowired
	UserRepository uRepository;
	
	@Autowired
	PlayerRepository playerRepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	
	
	@RequestMapping(value= "/gamelist", method = RequestMethod.GET)
	public String newGame(Model model){
		List<Game> games = (List<Game>) gameRepository.findAll();
		model.addAttribute("games", games);
		return "gamelist";
		
}

	@RequestMapping(value="/games", method = RequestMethod.GET)
	public @ResponseBody List<Game> gameListRest(){
		return(List<Game>) gameRepository.findAll();
	}
	
	@RequestMapping(value="/game/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Game> findGameRest(@PathVariable("id") Long gameId){
	return gameRepository.findById(gameId);
	}
	
	@RequestMapping(value="/games", method = RequestMethod.POST)
	public @ResponseBody Game saveGameRest(@RequestBody Game game) {
		return gameRepository.save(game);
	}
	
	@RequestMapping(value = "/newgame", method = RequestMethod.GET)
	public String getNewGameForm(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("genres", gRepository.findAll());
		return "gameform";
	}
	
	@RequestMapping(value = "/newgame", method = RequestMethod.POST)
	public String saveGame(@ModelAttribute Game game) {
	gameRepository.save(game);
		return "redirect:/gamelist";
	}
	@RequestMapping(value = "/deletegame/{id}", method = RequestMethod.GET)
	public String deleteGame(@PathVariable("id") Long gameid) {
		gameRepository.deleteById(gameid);
		return "redirect:../gamelist";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editGame(@PathVariable("id")Long id, Model model) {
		model.addAttribute("game", gameRepository.findById(id));
		model.addAttribute("genres", gRepository.findAll());
		return "editgame";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String editedGame(@ModelAttribute Game game) {
		gameRepository.save(game);
		return "redirect:/gamelist";
	}
	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public String getNewUserForm(Model model) {
		model.addAttribute("user", new User());
		return "userform";
}//Yritetty tehdä uuden käyttäjän luominen//
	@RequestMapping(value = "/newuser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user) {
		uRepository.save(user);
		return "redirect:/gamelist";
	}
	@RequestMapping(value="/users", method = RequestMethod.POST)
	public @ResponseBody User saveUserRest(@RequestBody User user) {
		return uRepository.save(user);
	}
	@RequestMapping(value= "/playerlist", method = RequestMethod.GET)
	public String getPlayers(Model model){
		List<Player> players = (List<Player>) playerRepository.findAll();
		model.addAttribute("players", players);
		List<Game> games = (List<Game>) gameRepository.findAll();
		model.addAttribute("games", games);
		return "newplayer";
		
}
	@RequestMapping(value = "/newplayer", method = RequestMethod.POST)
	public String savePlayer(@ModelAttribute Player player) {
	playerRepository.save(player);
		return "redirect:/gamelist";
	}
	@RequestMapping(value = "/newplayer", method = RequestMethod.GET)
	public String getNewPlayerForm(Model model) {
		model.addAttribute("player", new Player());
		List<Player> players = (List<Player>) playerRepository.findAll();
		model.addAttribute("players", players);
		List<Game> games = (List<Game>) gameRepository.findAll();
		model.addAttribute("games", games);
		return "newplayer";
	}
	

}

