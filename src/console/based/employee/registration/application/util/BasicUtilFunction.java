package console.based.employee.registration.application.util;

import java.util.ArrayList;
import java.util.List;

import console.based.employee.registration.application.model.Employee;

public class BasicUtilFunction {

	public static void responseMapper(List<Employee> employees, int processnumber) {
		
			switch (processnumber) {
			case 1:
				System.out.println("Your registration is successful and entered employee details ");
				System.out.println(employees.get(0));
				break;
			case 2:
				System.out.println("Emplpyee details for the employee id"+employees.get(0).getId());
				System.out.println(employees.get(0));
				break;
			case 3:
				System.out.println("Below employee details is deleted successfully!");
				System.out.println(employees.get(0));
				break;
			case 4:
				System.out.println("List of employee details");
				for (Employee emp : employees) {
					System.out.println(emp);
				}
				break;
			case 5:
				System.out.println("Below employee details is updated successfully!");
				System.out.println(employees.get(0));
				break;
			default:
				System.out.println("You have enter wrong option");
				return;
			}
	}
}
