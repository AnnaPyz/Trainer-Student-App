package app.model;

public class Kursant {
	private String login;
	private String pass;
	private int upraw;
	private String imie;
	private String nazwisko;
	private String grupa;
	private String telefon;
	private String mail;
	private String github;
	
	
	
	
	
	public Kursant(String login, String pass, int upraw, String imie, String nazwisko, String grupa, String telefon,
			String mail, String github) {
		this.login = login;
		this.pass = pass;
		this.upraw = upraw;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.grupa = grupa;
		this.telefon = telefon;
		this.mail = mail;
		this.github = github;
		
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getUpraw() {
		return upraw;
	}
	public void setUpraw(int upraw) {
		this.upraw = upraw;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getGrupa() {
		return grupa;
	}
	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	
	

}
