package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import clases.Employee;
import clases.Ingredients;
import clases.Order;
import clases.Pizza;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class OrderController implements Initializable{
	
	ObservableList<Order> obserListOrder = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Order> orderTableView;
	
	@FXML
	private TableColumn<Order, String> nOrderTableColumn, orderTableColumn, hourTableColumn, stateTableColumn, priceTableColumn;
	
	private ArrayList<Pizza> orderList;
	
	private ArrayList<Ingredients> carbonaraList, buffaloChickenList, pecadoCarnalList, cheesixList, cremozzaBBQList;
	
	private Pizza p;
	
	private Ingredients i;
	
	private Order o; 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//chargeTable();
		chargeOrderPizzas();
		chargeTable();
	}
	
	public void chargeTable() {
		
		for (Order o : obserListOrder) {
			nOrderTableColumn.setCellFactory(new SimpleIntegerProperty(o.getId()));
		}
		
		
		
		
	}
	
	public void chargeOrderPizzas() {
		
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
		
		Pizza p1 = new Pizza(1, "Carbonara", carbonaraList, "Massa Fina", 36, 10.95, 1);
		Pizza p2 = new Pizza(2, "Buffalo Chicken", buffaloChickenList, "Massa Normal", 36, 14.95, 1);
		Pizza p3 = new Pizza(3, "Pecado Carnal", pecadoCarnalList, "Massa RollCheese", 36, 14.95, 1);
		Pizza p4 = new Pizza(4, "Cheesix", cheesixList, "Massa Gorda", 36, 19.95, 1);
		Pizza p5 = new Pizza(5, "Cremozza BBQ", cremozzaBBQList, "Massa Fina", 36, 12.95, 1);
		
		orderList.add(p1);
		orderList.add(p2);
		orderList.add(p5);
		o = new Order(1, "1/02/2020", "12:54", orderList, 40.90f);
		obserListOrder.add(o);
		orderList.clear();
		orderList.add(p2);
		orderList.add(p3);
		orderList.add(p4);
		o = new Order(1, "1/02/2020", "13:54", orderList, 45.90f);
		obserListOrder.add(o);
		orderList.clear();
		orderList.add(p1);
		orderList.add(p2);
		orderList.add(p5);
		orderList.add(p2);
		orderList.add(p4);
		o = new Order(1, "2/02/2020", "14:54", orderList, 70.90f);
		obserListOrder.add(o);
		orderList.clear();
		orderList.add(p5);
		orderList.add(p3);
		orderList.add(p4);
		o = new Order(1, "2/02/2020", "11:54", orderList, 50.90f);
		obserListOrder.add(o);
		orderList.clear();
		orderList.add(p3);
		orderList.add(p2);
		orderList.add(p5);
		o = new Order(1, "2/02/2020", "15:54", orderList, 33.90f);
		obserListOrder.add(o);
		orderList.clear();
		
		orderTableView.getItems().addAll(obserListOrder);
	}

}
