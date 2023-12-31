package in.fssa.myfashionstudioapp.model;

public class Gender {

	private int id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gender() {

	}

	public Gender(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Gender [id=" + id + ", name=" + name + "]";
	}

}
