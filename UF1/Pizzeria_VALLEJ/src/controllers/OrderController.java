package controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import clases.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/*
 * Antes de nada los datos modificados no tienen persistencia ya que no se a pedido como especificacion.
 */
public class OrderController implements Initializable {

	ObservableList<String> obserStateComboBoxItems = FXCollections.observableArrayList();

	@FXML
	private TableView<Order> orderTableView;

	@FXML
	private TableColumn<Order, String> nOrderTableColumn, orderTableColumn, hourTableColumn, stateTableColumn,
			priceTableColumn;

	@FXML
	private ComboBox<String> stateComboBox;

	@FXML
	private Button stateButton, removeOrder;

	@FXML
	private MenuBar orderMenuBar;

	@FXML
	private MenuItem preparedContextMenu, processedContextMenu,
			bakingContextMenu, readyContextMenu, distributionContextMenu;

	@FXML
	private ContextMenu orderContextMenu;



	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		chargeStateComboBox();
		chargeTable();

		/*
		 * Boton para modificar el estado de los pedidos
		 */
		stateButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				// Aqui cambio el estado de los pedidos
				Order mod = orderTableView.getSelectionModel().getSelectedItem();
				mod.setState(stateComboBox.getValue());

				Main.obserListOrder.set(orderTableView.getSelectionModel().getSelectedIndex(), mod);
			}
		});

		/*
		 * Hago un setOnAction para cada opcion del ContextMenu para a si poder cambiar el estado en la tabl,
		 * no he encontrado otra manera de hacer el codigo mas optimizado,
		 * no he encontrado opciones de algo tipo IsSelected o algo a si para saber el seleccionado y pasarlo.
		 */
		preparedContextMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Order mod = orderTableView.getSelectionModel().getSelectedItem();
				mod.setState(preparedContextMenu.getText());

				Main.obserListOrder.set(orderTableView.getSelectionModel().getSelectedIndex(), mod);
			}
		});

		processedContextMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Order mod = orderTableView.getSelectionModel().getSelectedItem();
				mod.setState(processedContextMenu.getText());

				Main.obserListOrder.set(orderTableView.getSelectionModel().getSelectedIndex(), mod);
			}
		});

		bakingContextMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Order mod = orderTableView.getSelectionModel().getSelectedItem();
				mod.setState(bakingContextMenu.getText());

				Main.obserListOrder.set(orderTableView.getSelectionModel().getSelectedIndex(), mod);
			}
		});

		readyContextMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Order mod = orderTableView.getSelectionModel().getSelectedItem();
				mod.setState(readyContextMenu.getText());

				Main.obserListOrder.set(orderTableView.getSelectionModel().getSelectedIndex(), mod);
			}
		});

		distributionContextMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Order mod = orderTableView.getSelectionModel().getSelectedItem();
				mod.setState(distributionContextMenu.getText());

				Main.obserListOrder.set(orderTableView.getSelectionModel().getSelectedIndex(), mod);
			}
		});

	}

	/*
	 * Metodo para eliminar filas.
	 */
	public void removeOrder() {

		Main.obserListOrder.remove(orderTableView.getSelectionModel().getSelectedIndex());
	}

	/*
	 * Metodo que carga la tabla de nuevo con los datos modificados.
	 */
	public void chargeTable() {

		nOrderTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("id"));
		orderTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("pizzasString"));
		hourTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("hour"));
		stateTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("state"));
		priceTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("price"));

		orderTableView.setItems(Main.obserListOrder);

	}

	/*
	 * Metodo para rellenar el comboBox
	 */
	public void chargeStateComboBox() {

		obserStateComboBoxItems.addAll("Por preparar", "Oido Cocina", "En el horno", "Listo", "En reparto");
		stateComboBox.getItems().addAll(obserStateComboBoxItems);
	}

	/*
	 * Metodo para volver a la pantalla anterior por el MenuBar
	 */
	public void returnScreen() {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("../views/Menu.fxml"));
			Scene scene = new Scene(root, 720, 520);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			Stage primaryStage = (Stage) orderMenuBar.getScene().getWindow();
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
			Stage primaryStage = (Stage) orderMenuBar.getScene().getWindow();
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
			Stage stage = (Stage) orderMenuBar.getScene().getWindow();
			stage.close();
		}
	}

	
}
