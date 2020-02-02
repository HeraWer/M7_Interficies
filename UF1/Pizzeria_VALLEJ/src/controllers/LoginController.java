package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import clases.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	ObservableList<Employee> obserListEmployee = FXCollections.observableArrayList();

	@FXML
	private ListView<Employee> employeeListView;

	@FXML
	private Label employeeLabel;

	@FXML
	private Button addButtonEmployee, sendPasswordButton;

	@FXML
	private TextField employeeNameTextField, employeePositionTextField, employeePasswordTextField,
			sendPasswordTextField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println("Programa iniciado");
		chargeEmployee();
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

	public void chargeEmployee() {

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
		employeeListView.getItems().addAll(obserListEmployee);
		System.out.println("Empleados cargados");

	}

	public void addEmployee() {
		int id = obserListEmployee.size() + 1;
		obserListEmployee.clear();
		Employee e = new Employee(id, employeeNameTextField.getText(), employeePositionTextField.getText(),
				employeePasswordTextField.getText());
		obserListEmployee.add(e);
		employeeListView.getItems().addAll(obserListEmployee);
		System.out.println("Nuevo empleado añadido");

	}

	public void changeWindow(Event event) {

		Boolean result = resultPassword(sendPasswordTextField.getText());
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
			System.out.println("Contraseña erronea");
		}
	}

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
