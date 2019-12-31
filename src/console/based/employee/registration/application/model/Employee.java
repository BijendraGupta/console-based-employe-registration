/**
 * 
 */
package console.based.employee.registration.application.model;

/**
 * @author Bijendra
 *
 */
public class Employee {

	private Integer id;

	private String name;

	private String address;

	private String designation;

	private String sex;

	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Employee Details Id- "+id+" Name- " +name+" Address- "+address +" Designation- "+designation +" Sex- "+sex;
	}
	
}
