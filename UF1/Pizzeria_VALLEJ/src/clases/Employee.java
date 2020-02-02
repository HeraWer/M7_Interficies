package clases;

public class Employee {

	private int id;
	private String name;
	private String position;
	private String password;

	public Employee(int id, String name, String position, String password) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.password = password;
	}

	public Employee() {
		super();
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return name;
	}

}
