package com.agenda.online.web.dto;

public class UserRegistrationDto
{
	private String name;
    private String nick;
    private String email;
    private String password;
    
    public UserRegistrationDto(String name, String nick, String email, String password) {
		super();
		this.name = name;
		this.nick = nick;
		this.email = email;
		this.password = password;
	}
    
	public UserRegistrationDto() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
