package hhswd.harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

private String gamename;

private int year;

@ManyToOne
@JsonIgnore
@JoinColumn(name = "genreid")
private Genre genre;
public Game() {
	super();
	this.id = null;
	this.gamename = null;
	this.year = 0;
}


public Game(String gamename, int year, Genre genre) {
	super();
	this.gamename = gamename;
	this.year = year;
	this.genre = genre;
}
public Game(Long id, String gamename, int year, Genre genre ) {
	super();
	this.id = id;
	this.gamename = gamename;
	this.year = year;
	this.genre = genre;
}


public void setId(Long id) {
	this.id = id;
}


public void setGamename(String gamename) {
	this.gamename = gamename;
}


public void setYear(int year) {
	this.year = year;
}


public Long getId() {
	return id;
}
public void setGenre(Genre genre) {
	this.genre = genre;
}
public Genre getGenre() {
	return genre;
}


public String getGamename() {
	return gamename;
}


public int getYear() {
	return year;
}


@Override
public String toString() {
	if(this.genre !=null)
	return "Game [id=" + id + ", gamename=" + gamename + ", year=" + year + this.getGenre() +"]";
	
	else
		return "Game [id="+ id +",gamename=" + gamename + ", year=" + year + "]";
}

}
