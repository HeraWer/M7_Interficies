package controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import clases.Ingredients;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StockController implements Initializable{
	
	@FXML
	private TableView<Ingredients> ingredientsTableView;
	
	@FXML
	private TableColumn<Ingredients, String> idIngredientsTableColumn, nameIngredientsTableColumn, stockIngredientsTableColumn;
	
	@FXML
	private MenuBar stockMenuBar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		chargeListView();
	}
	
	/*
	 * Cargamos la tabla a partir de los datos declarados en el Main
	 */
	public void chargeListView() {
		
		idIngredientsTableColumn.setCellValueFactory(new PropertyValueFactory<Ingredients, String>("id"));
		nameIngredientsTableColumn.setCellValueFactory(new PropertyValueFactory<Ingredients, String>("name"));
		stockIngredientsTableColumn.setCellValueFactory(new PropertyValueFactory<Ingredients, String>("stock"));
		
		ingredientsTableView.getItems().addAll(Main.obserListIngredients);
	}
	
	/*
	 * Metodo para volver a la pantalla de iniciar sesion por el MenuBar
	 */
	public void logoutScreen() {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
			Scene scene = new Scene(root, 720, 520);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			Stage primaryStage = (Stage) stockMenuBar.getScene().getWindow();
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
			Stage stage = (Stage) stockMenuBar.getScene().getWindow();
			stage.close();
		}
	}
	
	/*
	 * Metodo para volver a la pantalla anterior por el MenuBar
	 */
	public void returnScreen() {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("../views/Menu.fxml"));
			Scene scene = new Scene(root, 720, 520);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			Stage primaryStage = (Stage) stockMenuBar.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
