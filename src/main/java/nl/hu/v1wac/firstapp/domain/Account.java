package nl.hu.v1wac.firstapp.domain;

public class Account {
	private String Username;
	private String Password;
	private String role;
	private String email;
	private int telefoonnummer;
	private String adres;
	
	public Account(String Username, String Password, String role) {
		this.Username = Username;
		this.Password = Password;
		this.role = role;
	}
	
	public Account(String Username, String Password, String role, String email, int telefoonnummer, String adres) {
		this.Username = Username;
		this.Password = Password;
		this.role = role;
		this.email = email;
		this.telefoonnummer = telefoonnummer;
		this.adres = adres;
	}

	public String getUsername() {
		return Username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(int telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
