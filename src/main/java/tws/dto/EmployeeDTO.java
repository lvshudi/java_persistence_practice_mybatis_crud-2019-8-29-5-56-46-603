package tws.dto;

public class EmployeeDTO {
	private String id;
	private String name;
	private String age;
	private String desc;

	public EmployeeDTO(String id, String name, String age, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public EmployeeDTO() {
	}

	public EmployeeDTO(String id, String name, String age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
