package Model;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Gestione {
	private ArrayList<Utente> arrayut = new ArrayList<Utente>();
	private JsonParse jreader;
	private JSONArray array;
	private JSONObject obj;
	private String selectUtStand="select%20*%20from%20utenti";
	private String selectUtAdmin="select%20*%20from%20utenti_admin";
	private String insertUt;
	private String insertProduct;
	private StringBuilder response;
	private String inputLine;
	private String s;
	private BufferedReader in;

	public Gestione() {
		jreader=new JsonParse();
	}
	//Inserisci un nuovo utente
	public boolean addUtente(Utente e) {
		boolean b = false;
		try {
			URL url1 = new URL(
                    "http://prova12344.altervista.org/ProgettoEsame/login.php?tipo=insert&query=insert%20into%20utenti%20values(null,'"+e.getNome()+"','"+e.getPassword()+"','"+e.getCognome()+"','"+e.getEmail()+"');");
			

			HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/4.76");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				response.append(inputLine);
			in.close();
			String s = response.toString(); // Il risultato della pagina
			System.out.println(s+"AAAA");
			
			b=true;
			connection.disconnect();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		return b;
	}

	public int nUtenti() {
		int i = 0;
		return i;
	}
	//Stampa degli utenti registrati
	public ArrayList<Utente> stampaUtenti() {
		arrayut.clear();
		
		try {
			URL url1 = new URL(
					"http://prova12344.altervista.org/ProgettoEsame/login.php?tipo=select&query="+selectUtStand);
			HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/4.76");
			connection.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				response.append(inputLine);
			in.close();
			String s = response.toString(); // Il risultato della pagina
			array = jreader.responseJson(s);
			for (int i = 0; i < array.size(); i++) {
				obj = (JSONObject) array.get(i);
				arrayut.add(new Utente(obj.get("nome").toString(), obj.get("cognome").toString(),
						obj.get("email").toString(), obj.get("password").toString()));
			}
			connection.disconnect();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return arrayut;
	}
	//Controllo Login
	public String controllo(String nome, String password) {
		String c = "nessuno";
		try {
			//controllo se è utente root
			URL url1 = new URL(
					"http://prova12344.altervista.org/ProgettoEsame/login.php?query="+selectUtAdmin);
			HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/4.76");
			connection.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				response.append(inputLine);
			in.close();
			String s = response.toString();
			String nm, pass;
			array = jreader.responseJson(s);
			for (int i=0;i<array.size();i++) {
				obj = (JSONObject) array.get(i);
				nm = obj.get("nome").toString();
				pass = obj.get("password").toString();
				if (nm.compareTo(nome) == 0 && pass.compareTo(password) == 0) {
					c = "root";
				}
			}
			connection.disconnect();
			//controllo se è utente standard
			url1 = new URL(
					"http://prova12344.altervista.org/ProgettoEsame/login.php?query="+selectUtStand);
			connection = (HttpURLConnection) url1.openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/4.76");
			connection.setRequestMethod("GET");
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			response = new StringBuilder();
			
			while ((inputLine = in.readLine()) != null)
				response.append(inputLine);
			in.close();
			 s = response.toString();
			
			array = jreader.responseJson(s);
			for (int i=0;i<array.size();i++) {
				obj = (JSONObject) array.get(i);
				nm = obj.get("nome").toString();
				pass = obj.get("password").toString();
				if (nm.compareTo(nome) == 0 && pass.compareTo(password) == 0) {
					c = "standard";
				}
			}
			connection.disconnect();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("\nDone");
		}
		return c;
	}
	//Inserimento prodotto
	public boolean addProdotto(Prodotto p) {
		boolean c = false;
		try {
		URL url1 = new URL(
				"http://prova12344.altervista.org/ProgettoEsame/login.php?query=insert%20into%20prodotti%20values(null,'" + p.getNome() + "','" + p.getDescrizione() + "','" + 
				+ p.getPrezzo() + "','" + p.getSconto() + "','" + p.getIngredienti() + "','"
				+ p.getProvenienza() + "','" + p.getTipologia() + "','"+p.getQuantita()+"');");
			HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
			c=true;
			connection.disconnect();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;

	}

	
}
