package Model;

public class Utente {
	private String nome, cognome, email, password;
	private int id;

	public Utente(String nome, String cognome, String email, String password, int id) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.id = id;
	}

	public Utente(String nome, String cognome, String email, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Utente Nome=" + nome + ", Cognome=" + cognome + ", Email=" + email + ", Password=" + password + ", Id="
				+ id + "]";
	}

}
