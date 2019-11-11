package hhswd.harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long genreid;
private String genrename;

@OneToMany(cascade = CascadeType.ALL, mappedBy= "genre")
private List<Game> games;

public Genre () {}

public Genre(String genrename) {
	super();
	this.genrename = genrename;
}
public Long getGenreid() {
	return genreid;
}
public void setGenreid(Long genreid) {
	this.genreid = genreid;
}
public String getGenrename() {
	return genrename;
}
public void setGenrename(String genrename) {
	this.genrename = genrename;
}
public List<Game> getGames(){
	return games;
}
public void setGame(List<Game> games) {
	this.games = games;
}

@Override
public String toString() {
	return "Genre [genreid=" + genreid + ", genrename=" + genrename + "]";
}

}
