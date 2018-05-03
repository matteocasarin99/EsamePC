package Model;

public class Prodotto {
	private String nome, descrizione, ingredienti, provenienza, tipologia;
	private float prezzo, sconto;
	private int quantita;

	public Prodotto(String nome, String descrizione, String ingredienti, String provenienza, float prezzo, float sconto,
			String tipologia,int quantita) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.ingredienti = ingredienti;
		this.provenienza = provenienza;
		this.prezzo = prezzo;
		this.sconto = sconto;
		this.tipologia = tipologia;
		this.quantita=quantita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(String ingredienti) {
		this.ingredienti = ingredienti;
	}

	public String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public float getSconto() {
		return sconto;
	}

	public void setSconto(float sconto) {
		this.sconto = sconto;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", descrizione=" + descrizione + ", ingredienti=" + ingredienti
				+ ", provenienza=" + provenienza + ", tipologia=" + tipologia + ", prezzo=" + prezzo + ", sconto="
				+ sconto + ", quantita=" + quantita + "]";
	}
}
