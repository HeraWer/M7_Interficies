package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controlador implements Initializable {
	
	@FXML
	private TextField idNombre, idTelefono;
	
	@FXML
	private CheckBox chkFutbol, chkTenis, chkBaloncesto;
	
	@FXML
	private RadioButton rdHombre, rdMujer;
	
	@FXML
	private Label lblPedido;
	
	private String chkResult;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
	public void mostrar() {
		
		System.out.println("Su nombre es: " + idNombre.getText());
		System.out.println("Su numero de telefono es " + idTelefono.getText());
		if(rdHombre.isSelected()) {
			System.out.println("Su sexo es: " + rdHombre.getText());
		}else if(rdMujer.isSelected()) {
			System.out.println("Su sexo es: " + rdMujer.getText());
		}
		
		if(chkFutbol.isSelected()) {
			chkResult = chkFutbol.getText();
		}if(chkTenis.isSelected()) {
			chkResult = chkResult + " " + chkTenis.getText();
		}if(chkBaloncesto.isSelected()) {
			chkResult = chkResult + " " + chkBaloncesto.getText(); 
		}
		
		System.out.println("Los deportes que le gustan son: " + chkResult);
	}

}
