package controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import application.Main;
import clases.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	

	@FXML
	private ListView<Employee> employeeListView;

	@FXML
	private Label employeeLabel;

	@FXML
	private Button addButtonEmployee, sendPasswordButton;
	
	@FXML
	private MenuBar loginMenuBar;

	@FXML
	private TextField employeeNameTextField, employeePositionTextField, employeePasswordTextField;
	
	@FXML
	private PasswordField sendPasswordField; 

	/*
	 * Boton para comprobar la contraseña y saltar de escena.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println("Programa iniciado");
		employeeListView.getItems().addAll(Main.obserListEmployee);
		sendPasswordButton = new Button();
		sendPasswordButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("Entro boton");
				changeWindow(event);
			}
		});
	}

	
	
	
	/*
	 * Metodo para añadir nuevos empleados.
	 */
	public void addEmployee() {
		int id = Main.obserListEmployee.size() + 1;
		//Main.obserListEmployee.clear();
		Employee e = new Employee(id, employeeNameTextField.getText(), employeePositionTextField.getText(),
				employeePasswordTextField.getText());
		Main.obserListEmployee.add(e);
		employeeListView.getItems().addAll(Main.obserListEmployee);
		System.out.println("Nuevo empleado añadido");

	}

	/*
	 * Metodo para cambiar ds escena si la contraseña es correcta.
	 */
	public void changeWindow(Event event) {

		Boolean result = resultPassword(sendPasswordField.getText());
		if (result) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../views/Menu.fxml"));
				Scene scene = new Scene(root, 720, 520);
				Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			
			/*
			 * Dialogo de contraseña erronea
			 */
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Tu contraseña a sido erronea vuelva a intentarlo.");
			alert.showAndWait();
			sendPasswordField.setText("");
			System.out.println("Contraseña erronea");
		}
	}
	
	/*
	 * Metodo para cerrar la ventana por el menuBar con un alert para confirmar
	 */
	public void screenClose() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Dialogo de confirmacion");
		alert.setHeaderText(null);
		alert.setContentText("De verdad que quieres salir?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			Stage stage = (Stage) loginMenuBar.getScene().getWindow();
			stage.close();
		}
	}

	/*
	 * Metodo para saber si la contraseña es correcta o no.
	 */
	public Boolean resultPassword(String password) {
		
		System.out.println("Comprobando contraseña");
		
		Boolean result = false;
		if (!employeeListView.getSelectionModel().isEmpty()) {
			String p = employeeListView.getSelectionModel().getSelectedItem().getPassword();
			if (p.equalsIgnoreCase(password)) {
				result = true;
			}
		}
		return result;
	}

}
