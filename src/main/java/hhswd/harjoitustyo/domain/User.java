package hhswd.harjoitustyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name= "id", nullable = false, updatable = false)
private Long id;


@Column(name = "username", nullable = false, unique = true)
private String username;

@Column(name = "password", nullable = false)
private String passwordHash;

@Column(name ="role", nullable = false)
private String role;

@Column(name = "email", nullable = false)
private String email;


public User() {
	super();
	this.id = null;
	this.username = null;
	this.passwordHash = null;
	this.role = null;
	this.email = null;
}



public User(String username, String passwordHash, String role, String email) {
	super();
	this.username = username;
	this.passwordHash = passwordHash;
	this.role = role;
	this.email = email;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPasswordHash() {
	return passwordHash;
}
public void setPasswordHas(String passwordHash) {
	this.passwordHash = passwordHash;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", role=" + role
			+ ", email=" + email + "]";
}
}

