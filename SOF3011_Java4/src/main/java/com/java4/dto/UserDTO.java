package com.java4.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDTO extends AbstractDTO<UserDTO> {

	private String username;
	private String password;
	private String fullname;
	private String email;
	private boolean role;
	private boolean status;
	private String verify;
	private Set<MovieDTO> movies = new HashSet<>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	public Set<MovieDTO> getMovies() {
		return movies;
	}

	public void setMovies(Set<MovieDTO> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", fullname=" + fullname + ", email="
				+ email + ", role=" + role + ", status=" + status + ", verify=" + verify + ", movies=" + movies + "]";
	}

}