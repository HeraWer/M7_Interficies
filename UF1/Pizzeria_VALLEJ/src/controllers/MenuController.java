package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import clases.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MenuController implements Initializable{

	ObservableList<Employee> obserListEmployee = FXCollections.observableArrayList();
	
	@FXML
	private ListView<Employee> employeeListView;
	
	@FXML
	private Label employeeLabel;
	
	@FXML
	private Button addButtonEmployee;
	
	@FXML
	private TextField employeeNameTextField, employeePositionTextField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		chargeEmployee();
	}
	
	public void chargeEmployee() {
		
		obserListEmployee.clear();
		
		Employee e = new Employee();
		e = new Employee(1, "Jonatan", "Vendedor");
		obserListEmployee.add(e);
		e = new Employee(2, "Sergio", "Vendedor");
		obserListEmployee.add(e);
		e = new Employee(3, "Adrian", "Vendedor");
		obserListEmployee.add(e);
		e = new Employee(4, "Julio", "Encargado");
		obserListEmployee.add(e);
		e = new Employee(5, "Antonio", "Repartidor");
		obserListEmployee.add(e);
		e = new Employee(6, "Juan Carlos", "Cocinero");
		obserListEmployee.add(e);
		e = new Employee(7, "Marc", "Repartidor");
		obserListEmployee.add(e);
		e = new Employee(8, "Daniel", "Cocinero");
		obserListEmployee.add(e);
		e = new Employee(9, "Erik", "Encargado");
		obserListEmployee.add(e);
		e = new Employee(10, "Lidia", "Cocinera");
		obserListEmployee.add(e);
		e = new Employee(11, "Susana", "Repartidora");
		obserListEmployee.add(e);
		e = new Employee(12, "Angela", "Encargada");
		obserListEmployee.add(e);
		employeeListView.getItems().addAll(obserListEmployee);
		
	}
	
	public void addEmployee() {
		int id = obserListEmployee.size() + 1;
		obserListEmployee.clear();
		Employee e = new Employee(id, employeeNameTextField.getText(), employeePositionTextField.getText());
		obserListEmployee.add(e);
		employeeListView.getItems().addAll(obserListEmployee);
		
	}

}
