package hhswd.harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Player {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)

private Long playerid;
private String playername;
private String maingame;

@ManyToOne
@JsonIgnore
@JoinColumn(name = "id")
private Game game;


public Player() {
	super();
	this.playerid = null;
	this.playername = null;
	this.maingame = null;
}
public Player(String playername, String maingame, Game game) {
	super();
	this.playername = playername;
	this.maingame = maingame;
}
public Player(Long playerid, String playername, String maingame, Game game) {
super();
this.playerid = playerid;
this.playername = playername;
this.maingame = maingame;

}
@Override
public String toString() {
	return "Player [playerid=" + playerid + ", playername=" + playername + ", maingame=" + maingame + ", game=" + game
			+ "]";
}
public void setPlayerid(Long playerid) {
	this.playerid = playerid;
}
public void setPlayername(String playername) {
	this.playername = playername;
}
public void setMaingame(String maingame) {
	this.maingame = maingame;
}
public void setGame(Game game) {
	this.game = game;
}
public Long getPlayerid() {
	return playerid;
}
public String getPlayername() {
	return playername;
}
public String getMaingame() {
	return maingame;
}
public Game getGame() {
	return game;
}
}
