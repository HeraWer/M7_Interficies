package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController implements Initializable {

	@FXML
	private Button orderButton, stockButton, boxButton, logoutButton;

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
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
