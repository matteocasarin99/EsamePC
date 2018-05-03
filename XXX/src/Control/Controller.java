package Control;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Gestione;
import Model.Prodotto;
import Model.Utente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	private static Stage stage2;
	private static Stage stage1;
	private Gestione g = new Gestione();
	// frame accesso
	@FXML
	TextField nm;
	@FXML
	PasswordField psw;
	// frame root
	@FXML
	Tab change;
	@FXML
	ListView<Utente> jlist;
	// Prodotto
	@FXML
	TextField txtPrez;
	@FXML
	TextField txtNom;
	@FXML
	TextField cdProd;
	@FXML
	TextField txtScon;
	@FXML
	TextField txtProv;
	@FXML
	TextArea txtIngre;
	@FXML
	TextArea txtDesc;
	@FXML
	TextField txtTipo;
	@FXML
	Button btnIns;
	@FXML
	Button btnResetta;
	@FXML
	TextField txtQuant;
	// frame registrazione
	@FXML
	TextField nmReg;
	@FXML
	TextField emailReg;
	@FXML
	TextField CgnReg;
	@FXML
	PasswordField PswReg;
	@FXML
	Button btnInvReg;
	//frame utente standard
	@FXML
	TextField txtCerca;
	@FXML
	Tab tabCarrello;

	public Controller() {

	}

	public void click() {
		String name = nm.getText();
		String pswd = psw.getText();
		System.out.println(nm.getText() + " " + psw.getText());
		String contr = g.controllo(name, pswd);
		if (contr.compareTo("root") == 0) {
			try {
				stage1.close();
				stage2 = new Stage();
				Parent root2;
				root2 = FXMLLoader.load(getClass().getResource("/View/frameroot.fxml"));
				Scene scene2 = new Scene(root2);
				scene2.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
				stage2.setScene(scene2);
				stage2.show();
				
				
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else {
			if (contr.compareTo("standard") == 0) {
				try {
					stage1.close();
					stage2 = new Stage();
					Parent root2;
					root2 = FXMLLoader.load(getClass().getResource("/View/frameutente.fxml"));
					Scene scene2 = new Scene(root2);
					scene2.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
					stage2.setScene(scene2);
					stage2.show();
					
				} catch (Exception e2) {
					e2.printStackTrace();

				}
			} else {
				if (contr.compareTo("nessuno") == 0) {
					JOptionPane.showMessageDialog(null, "Utente o password errati", "Attenzione", 2);
				}
			}
		}

	}

	public static void setStage1(Stage stage) {
		stage1 = stage;
	}

	public void inserisci() {
		Prodotto p = new Prodotto(txtNom.getText(), txtDesc.getText(), txtIngre.getText(), txtProv.getText(),
				Float.parseFloat(txtPrez.getText()), Float.parseFloat(txtScon.getText()), txtTipo.getText(),Integer.parseInt(txtQuant.getText()));
		if (g.addProdotto(p)) {
			JOptionPane.showMessageDialog(null, "Inserito", "Success", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Prodotto NON inserito", "Attenzione", 2);
		}
	}

	public void resetta() {
		txtPrez.setText("");
		txtNom.setText("");
		cdProd.setText("");
		txtScon.setText("");
		txtProv.setText("");
		txtIngre.setText("");
		txtDesc.setText("");
		txtTipo.setText("");
	}

	public void clickReg() {
		try {
			stage1.close();
			stage2 = new Stage();
			Parent root2;
			root2 = FXMLLoader.load(getClass().getResource("/View/registrazione.fxml"));
			Scene scene2 = new Scene(root2);
			scene2.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
			stage2.setScene(scene2);
			stage2.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void registrazione() {
		Utente e = new Utente(nmReg.getText(), CgnReg.getText(), emailReg.getText(), PswReg.getText());
		boolean controllo = g.addUtente(e);
		if (controllo) {
			JOptionPane.showMessageDialog(null, "Registrazione Effettuata!", "Success", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Registrazione NON effettuata!", "Attenzione", 2);
		}
		try {
			stage2.close();
			stage1 = new Stage();
			Parent root2;
			root2 = FXMLLoader.load(getClass().getResource("/View/example.fxml"));
			Scene scene2 = new Scene(root2);
			scene2.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
			stage1.setScene(scene2);
			stage1.show();
		} catch (Exception e2) {
			e2.printStackTrace();

		}
	}

	public void stampaChange() {
		jlist.getItems().clear();
		ArrayList<Utente> array = g.stampaUtenti();
		for (int i = 0; i < array.size(); i++) {
			jlist.getItems().add(array.get(i));
		}

	}
	public void cerca() {
		
	}
	public void aggiungicarr() {
		
	}

}
