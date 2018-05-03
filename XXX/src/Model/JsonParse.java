package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import java.net.*;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class JsonParse {
	private ArrayList<Utente> arrayut;

	public JsonParse() {

	}

	public JSONArray responseJson(String response) {
		JSONArray array = new JSONArray();
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(response);
			array = (JSONArray) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}
}