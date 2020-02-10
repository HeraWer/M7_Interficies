package application;

import java.util.ArrayList;

import clases.Employee;
import clases.Ingredients;
import clases.Order;
import clases.Pizza;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	public static ObservableList<Employee> obserListEmployee = FXCollections.observableArrayList();
	public static ObservableList<Order> obserListOrder = FXCollections.observableArrayList();
	public static ObservableList<Ingredients> obserListIngredients = FXCollections.observableArrayList();
	
	private ArrayList<Pizza> orderList;
	private ArrayList<Ingredients> carbonaraList, buffaloChickenList, pecadoCarnalList, cheesixList, cremozzaBBQList;
	
	private Ingredients i;
	private Order o;

	@Override
	public void start(Stage primaryStage) {

		try {
			chargeEmployee();
			System.out.println("Empleados cargados");
			chargeOrderPizzas();
			System.out.println("Pizzas cargadas");
			Parent root = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
			Scene scene = new Scene(root, 720, 520);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * Metodo para inflar la lista con empleados.
	 */
	public static void chargeEmployee() {

		obserListEmployee.clear();

		Employee e = new Employee();
		e = new Employee(1, "Jonatan", "Vendedor", "1234");
		obserListEmployee.add(e);
		e = new Employee(2, "Sergio", "Vendedor", "1234");
		obserListEmployee.add(e);
		e = new Employee(3, "Adrian", "Vendedor", "1234");
		obserListEmployee.add(e);
		e = new Employee(4, "Julio", "Encargado", "1234");
		obserListEmployee.add(e);
		e = new Employee(5, "Antonio", "Repartidor", "1234");
		obserListEmployee.add(e);
		e = new Employee(6, "Juan Carlos", "Cocinero", "1234");
		obserListEmployee.add(e);
		e = new Employee(7, "Marc", "Repartidor", "1234");
		obserListEmployee.add(e);
		e = new Employee(8, "Daniel", "Cocinero", "1234");
		obserListEmployee.add(e);
		e = new Employee(9, "Erik", "Encargado", "1234");
		obserListEmployee.add(e);
		e = new Employee(10, "Lidia", "Cocinera", "1234");
		obserListEmployee.add(e);
		e = new Employee(11, "Susana", "Repartidora", "1234");
		obserListEmployee.add(e);
		e = new Employee(12, "Angela", "Encargada", "1234");
		obserListEmployee.add(e);
		System.out.println("Empleados cargados");

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
		obserListIngredients.add(i);

		i = new Ingredients(2, "Tomate", 200);
		carbonaraList.add(i);
		buffaloChickenList.add(i);
		pecadoCarnalList.add(i);
		cheesixList.add(i);
		cremozzaBBQList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(3, "Cebolla", 200);
		carbonaraList.add(i);
		buffaloChickenList.add(i);
		cremozzaBBQList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(4, "Salsa Carbonara", 200);
		carbonaraList.add(i);
		cremozzaBBQList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(5, "Bacon", 200);
		carbonaraList.add(i);
		buffaloChickenList.add(i);
		cremozzaBBQList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(6, "Champiñon", 200);
		carbonaraList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(7, "Pollo Bufalo", 300);
		buffaloChickenList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(8, "Salsa BBQ", 100);
		buffaloChickenList.add(i);
		cremozzaBBQList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(9, "Carne Vacuno", 150);
		pecadoCarnalList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(10, "Pepperoni", 150);
		pecadoCarnalList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(11, "York", 150);
		pecadoCarnalList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(12, "Cheddar", 500);
		cheesixList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(13, "Emmental", 500);
		cheesixList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(14, "Gorgonzola", 500);
		cheesixList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(15, "Que de Cabra", 500);
		cheesixList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(16, "Parmesano", 500);
		cheesixList.add(i);
		obserListIngredients.add(i);

		i = new Ingredients(17, "Pollo a la Parrila", 300);
		cremozzaBBQList.add(i);
		obserListIngredients.add(i);

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
