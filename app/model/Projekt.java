package app.model;

public class Projekt {
	private int id;
	private String temat;
	private String opis;
	private String termin;
	private String grupa;
	private int zrobione;
	private int ocena;
	
	public Projekt() {
	}


	public Projekt(int id, String temat, String opis, String termin, String grupa, int zrobione, int ocena) {
		this.id = id;
		this.temat = temat;
		this.opis = opis;
		this.termin = termin;
		this.grupa = grupa;
		this.zrobione = zrobione;
		this.ocena = ocena;
	}

	public Projekt(String temat, String opis, String termin) {
		this.temat = temat;
		this.opis = opis;
		this.termin = termin;
	}

	public Projekt(String temat, String opis, String termin, String grupa) {
		this.temat = temat;
		this.opis = opis;
		this.termin = termin;
		this.grupa = grupa;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTemat() {
		return temat;
	}


	public void setTemat(String temat) {
		this.temat = temat;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}


	public String getTermin() {
		return termin;
	}


	public void setTermin(String termin) {
		this.termin = termin;
	}


	public String getGrupa() {
		return grupa;
	}


	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}


	public int getZrobione() {
		return zrobione;
	}


	public void setZrobione(int zrobione) {
		this.zrobione = zrobione;
	}


	public int getOcena() {
		return ocena;
	}


	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	

}
