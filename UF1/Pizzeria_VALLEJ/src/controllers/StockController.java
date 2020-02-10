package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import clases.Ingredients;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StockController implements Initializable{
	
	@FXML
	private TableView<Ingredients> ingredientsTableView;
	
	@FXML
	private TableColumn<Ingredients, String> idIngredientsTableColumn, nameIngredientsTableColumn, stockIngredientsTableColumn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		chargeListView();
	}
	
	public void chargeListView() {
		
		idIngredientsTableColumn.setCellValueFactory(new PropertyValueFactory<Ingredients, String>("id"));
		nameIngredientsTableColumn.setCellValueFactory(new PropertyValueFactory<Ingredients, String>("name"));
		stockIngredientsTableColumn.setCellValueFactory(new PropertyValueFactory<Ingredients, String>("stock"));
		
		ingredientsTableView.getItems().addAll(Main.obserListIngredients);
	}
}
