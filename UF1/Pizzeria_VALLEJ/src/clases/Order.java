package clases;

import java.util.List;

public class Order {

	private int id;
	private String date;
	private String hour;
	private List<Pizza> pizzas;
	private String state;
	private Float price;
	private String pizzasString = "";

	public Order(int id, String date, String hour, List<Pizza> pizzas, String state, Float price) {
		super();
		this.id = id;
		this.date = date;
		this.hour = hour;
		this.pizzas = pizzas;
		this.price = price;
		this.state = state;
		this.convertPizzaList();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPizzasString() {
		return pizzasString;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPizzasString(String pizzasString) {
		this.pizzasString = pizzasString;
	}

	public void convertPizzaList() {
		for (Pizza pizza : pizzas) {
			pizzasString = pizzasString + pizza.getName() + "\n";
		}
	}
}
