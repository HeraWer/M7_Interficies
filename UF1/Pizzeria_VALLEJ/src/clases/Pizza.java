package clases;

import java.util.ArrayList;

public class Pizza {

	private int id;
	private String name;
	private ArrayList<Ingredients> ingredients;
	private String mass;
	private String size;
	private Double price;
	private int stock;

	public Pizza(int id, String name, ArrayList<Ingredients> ingredients, String mass, String size, Double price,
			int stock) {
		super();
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.mass = mass;
		this.size = size;
		this.price = price;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamee() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
