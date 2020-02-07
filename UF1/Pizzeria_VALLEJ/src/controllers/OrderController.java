package controllers;

import java.awt.ItemSelectable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import clases.Ingredients;
import clases.Order;
import clases.Pizza;
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

public class OrderController implements Initializable {

	ObservableList<Order> obserListOrder = FXCollections.observableArrayList();
	ObservableList<Order> obserListOrderAux = FXCollections.observableArrayList();
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
	private MenuItem orderMenuItemReturn, orderMenuItemClose, preparedContextMenu, processedContextMenu,
			bakingContextMenu, readyContextMenu, distributionContextMenu;

	@FXML
	private ContextMenu orderContextMenu;

	private ArrayList<Pizza> orderList;
	private ArrayList<Ingredients> carbonaraList, buffaloChickenList, pecadoCarnalList, cheesixList, cremozzaBBQList;

	private Pizza p;
	private Ingredients i;
	private Order o;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// chargeTable();
		chargeOrderPizzas();
		chargeStateComboBox();
		chargeTable();

		/*
		 * Boton para modificar el estado de los pedidos
		 */
		stateButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub

				// Aqui cambio el estado de los pedidos
				Order mod = orderTableView.getSelectionModel().getSelectedItem();
				mod.setState(stateComboBox.getValue());

				obserListOrder.set(orderTableView.getSelectionModel().getSelectedIndex(), mod);
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

				obserListOrder.set(orderTableView.getSelectionModel().getSelectedIndex(), mod);
			}
		});

		processedContextMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Order mod = orderTableView.getSelectionModel().getSelectedItem();
				mod.setState(processedContextMenu.getText());

				obserListOrder.set(orderTableView.getSelectionModel().getSelectedIndex(), mod);
			}
		});

		bakingContextMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Order mod = orderTableView.getSelectionModel().getSelectedItem();
				mod.setState(bakingContextMenu.getText());

				obserListOrder.set(orderTableView.getSelectionModel().getSelectedIndex(), mod);
			}
		});

		readyContextMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Order mod = orderTableView.getSelectionModel().getSelectedItem();
				mod.setState(readyContextMenu.getText());

				obserListOrder.set(orderTableView.getSelectionModel().getSelectedIndex(), mod);
			}
		});

		distributionContextMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Order mod = orderTableView.getSelectionModel().getSelectedItem();
				mod.setState(distributionContextMenu.getText());

				obserListOrder.set(orderTableView.getSelectionModel().getSelectedIndex(), mod);
			}
		});

	}

	/*
	 * Metodo para eliminar filas.
	 */
	public void removeOrder() {

		obserListOrder.remove(orderTableView.getSelectionModel().getSelectedIndex());
	}

	/*
	 * Metodo que carga la tabla de nuevo con los datos modificados.
	 */
	public void chargeTable() {

		nOrderTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("Id"));
		orderTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("pizzasString"));
		hourTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("hour"));
		stateTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("state"));
		priceTableColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("price"));

		orderTableView.setItems(obserListOrder);

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

	/*
	 * Metodo para cargar toda la tabla de pedidos.
	 */
	public void chargeOrderPizzas() {

		/*
		 * Creo listas para las pizzas con sus ingredientes.
		 */
		carbonaraList = new ArrayList<>();
		buffaloChickenList = new ArrayList<>();
		pecadoCarnalList = new ArrayList<>();
		cheesixList = new ArrayList<>();
		cremozzaBBQList = new ArrayList<>();
		orderList = new ArrayList<>();

		/*
		 * Añado los objetos ingredientes a las listas.
		 */
		i = new Ingredients(1, "Mozzarella", 200);
		carbonaraList.add(i);
		buffaloChickenList.add(i);
		pecadoCarnalList.add(i);
		cheesixList.add(i);
		cremozzaBBQList.add(i);

		i = new Ingredients(2, "Tomate", 200);
		carbonaraList.add(i);
		buffaloChickenList.add(i);
		pecadoCarnalList.add(i);
		cheesixList.add(i);
		cremozzaBBQList.add(i);

		i = new Ingredients(3, "Cebolla", 200);
		carbonaraList.add(i);
		buffaloChickenList.add(i);
		cremozzaBBQList.add(i);

		i = new Ingredients(4, "Salsa Carbonara", 200);
		carbonaraList.add(i);
		cremozzaBBQList.add(i);

		i = new Ingredients(5, "Bacon", 200);
		carbonaraList.add(i);
		buffaloChickenList.add(i);
		cremozzaBBQList.add(i);

		i = new Ingredients(6, "Champiñon", 200);
		carbonaraList.add(i);

		i = new Ingredients(7, "Pollo Bufalo", 300);
		buffaloChickenList.add(i);

		i = new Ingredients(8, "Salsa BBQ", 100);
		buffaloChickenList.add(i);
		cremozzaBBQList.add(i);

		i = new Ingredients(9, "Carne Vacuno", 150);
		pecadoCarnalList.add(i);

		i = new Ingredients(10, "Pepperoni", 150);
		pecadoCarnalList.add(i);

		i = new Ingredients(11, "York", 150);
		pecadoCarnalList.add(i);

		i = new Ingredients(12, "Cheddar", 500);
		cheesixList.add(i);

		i = new Ingredients(13, "Emmental", 500);
		cheesixList.add(i);

		i = new Ingredients(14, "Gorgonzola", 500);
		cheesixList.add(i);

		i = new Ingredients(15, "Que de Cabra", 500);
		cheesixList.add(i);

		i = new Ingredients(16, "Parmesano", 500);
		cheesixList.add(i);

		i = new Ingredients(17, "Pollo a la Parrila", 300);
		cremozzaBBQList.add(i);

		/*
		 * Creo objetos pizzas
		 */
		Pizza p1 = new Pizza(1, "Carbonara", carbonaraList, "Massa Fina", 36, 10.95, 1);
		Pizza p2 = new Pizza(2, "Buffalo Chicken", buffaloChickenList, "Massa Normal", 36, 14.95, 1);
		Pizza p3 = new Pizza(3, "Pecado Carnal", pecadoCarnalList, "Massa RollCheese", 36, 14.95, 1);
		Pizza p4 = new Pizza(4, "Cheesix", cheesixList, "Massa Gorda", 36, 19.95, 1);
		Pizza p5 = new Pizza(5, "Cremozza BBQ", cremozzaBBQList, "Massa Fina", 36, 12.95, 1);

		/*
		 * Añado las pizzas a una lista de pedidos que luego rellenara el objeto Order y
		 * ese objeto estara dentro de un observableList para rellenar la tableView
		 */
		orderList.add(p1);
		orderList.add(p2);
		orderList.add(p5);
		o = new Order(1, "1/02/2020", "12:54", orderList, "Por preparar", 40.90f);
		obserListOrder.add(o);
		orderList.clear();
		orderList.add(p2);
		orderList.add(p3);
		orderList.add(p4);
		o = new Order(2, "1/02/2020", "13:54", orderList, "Por preparar", 45.90f);
		obserListOrder.add(o);
		orderList.clear();
		orderList.add(p1);
		orderList.add(p2);
		orderList.add(p5);
		orderList.add(p2);
		orderList.add(p4);
		o = new Order(3, "2/02/2020", "14:54", orderList, "Por preparar", 70.90f);
		obserListOrder.add(o);
		orderList.clear();
		orderList.add(p5);
		orderList.add(p3);
		orderList.add(p4);
		o = new Order(4, "2/02/2020", "11:54", orderList, "Por preparar", 50.90f);
		obserListOrder.add(o);
		orderList.clear();
		orderList.add(p3);
		orderList.add(p2);
		orderList.add(p5);
		o = new Order(5, "2/02/2020", "15:54", orderList, "Por preparar", 33.90f);
		obserListOrder.add(o);
		orderList.clear();

	}

}
