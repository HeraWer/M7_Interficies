package clases;

public class Ingredients {

	private int id;
	private String name;
	private int stock;
	
	public Ingredients(int id, String name, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
