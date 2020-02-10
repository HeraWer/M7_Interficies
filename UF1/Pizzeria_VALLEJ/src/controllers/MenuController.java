package controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MenuController implements Initializable {

	@FXML
	private Button orderButton, stockButton, boxButton, logoutButton;
	
	@FXML
	private MenuBar menuMenuBar;
	

	/*
	 * Metodo initialize que contiene todos los MouseClicked para cambiar de escenas
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		orderButton = new Button();
		orderButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				changeWindowOrder(event);
			}
		});

		stockButton = new Button();
		stockButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				changeWindowStock(event);
			}
		});

		boxButton = new Button();
		boxButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				changeWindowBox(event);
			}
		});

		logoutButton = new Button();
		logoutButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				changeWindowLogout(event);
			}
		});
	}

	public void changeWindowOrder(Event event) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("../views/Orders.fxml"));
			Scene scene = new Scene(root, 720, 520);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeWindowStock(Event event) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("../views/Stock.fxml"));
			Scene scene = new Scene(root, 720, 520);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeWindowBox(Event event) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("../views/Box.fxml"));
			Scene scene = new Scene(root, 720, 520);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeWindowLogout(Event event) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
			Scene scene = new Scene(root, 720, 520);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Metodo para volver a la pantalla de iniciar sesion por el MenuBar
	 */
	public void logoutScreen() {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
			Scene scene = new Scene(root, 720, 520);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			Stage primaryStage = (Stage) menuMenuBar.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
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
			Stage stage = (Stage) menuMenuBar.getScene().getWindow();
			stage.close();
		}
	}

}
