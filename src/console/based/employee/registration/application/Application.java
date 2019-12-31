/**
 * 
 */
package console.based.employee.registration.application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import console.based.employee.registration.application.constant.Constants;
import console.based.employee.registration.application.dao.RegistrationDaoImpl;
import console.based.employee.registration.application.model.Employee;
import console.based.employee.registration.application.service.RegistrationService;
import console.based.employee.registration.application.service.RegistrationServiceImpl;
import console.based.employee.registration.application.util.BasicUtilFunction;

/**
 * @author Bijendra
 *
 */
public class Application {

	private static RegistrationService registrationService;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String args[]) {

		String isContinue = "N";

		System.out.println("Welcome to console based employee regitration");

		do {

			System.out.println("**************************************************************");

			System.out.println("Please enter preferred option for relevant operation");

			System.out.println("1.) Please enter 1 for do regitration");
			System.out.println("2.) Please enter 2 to get employee details for employee id");
			System.out.println("3.) Please enter 3 to delete employee by employee id ");
			System.out.println("4.) Please enter 4 to get all employee");
			System.out.println("5.) Please enter 5 to update employee for employee id");

			registrationService = new RegistrationServiceImpl();

			int processNumber = scan.nextInt();
			startRelevantProcess(processNumber);

			System.out.println("Do you want to continue ? Y/N");
			isContinue = scan.next();

			System.out.println("**************************************************************");

		} while (Constants.yes.equalsIgnoreCase(isContinue));

		if (registrationService != null) {
			if (registrationService instanceof RegistrationServiceImpl) {
				RegistrationDaoImpl daoImpl = ((RegistrationServiceImpl) registrationService)
						.getRegistrationDao() instanceof RegistrationDaoImpl
								? (RegistrationDaoImpl) (((RegistrationServiceImpl) registrationService)
										.getRegistrationDao())
								: null;
				try {
					if (daoImpl != null)
						daoImpl.getMySqlJDBC().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void startRelevantProcess(int processnumber) {
		Integer id;
		String name;
		String address;
		String designation;
		String sex;
		Integer age;
		Employee employee = null;
		List<Employee> employees = new ArrayList<Employee>();
		switch (processnumber) {
		case 1:
			System.out.println("You have selected a option for doing employee regitration!"
					+ "\nTo do so need to enter below details");

			System.out.println("Please enter Employee Id");
			id = scan.nextInt();
			scan.nextLine();
			System.out.println("Please enter Employee name");
			name = scan.nextLine();
			System.out.println("Please enter Employee Address");
			address = scan.nextLine();
			System.out.println("Please enter Employee Designation");
			designation = scan.nextLine();
			System.out.println("Please enter Employee Sex");
			sex = scan.next();
			System.out.println("Please enter Employee Age");
			age = scan.nextInt();

			employee = new Employee();
			employee.setAddress(address);
			employee.setAge(age);
			employee.setDesignation(designation);
			employee.setName(name);
			employee.setSex(sex);
			employee.setId(id);
			employee = registrationService.doRegistration(employee);
			employees.add(employee);
			break;
		case 2:
			System.out.println("You have selected a option to get employee details for employee id!"
					+ "\nTo do so need to enter below details");

			System.out.println("Please enter Employee Id");
			id = scan.nextInt();
			employee = registrationService.getEmployeeForEmpployeeId(id);
			employees.add(employee);
			break;
		case 3:
			System.out.println("You have selected a option for delete employee for employee id!"
					+ "\nTo do so need to enter below details");

			System.out.println("Please enter Employee Id");
			id = scan.nextInt();
			employee = registrationService.deleteEmployee(id);
			employees.add(employee);
			break;
		case 4:
			System.out.println("You have selected a option to get all employee!");
			employees = registrationService.getAllEmployees();
			break;
		case 5:
			System.out.println("You have selected a option for update employee for employee id!"
					+ "\nTo do so need to enter below details");

			System.out.println("Please enter Employee Id");
			id = scan.nextInt();
			System.out.println("Please enter new Employee name");
			name = scan.nextLine();
			System.out.println("Please enter new Employee Address");
			address = scan.nextLine();
			System.out.println("Please enter new Employee Designation");
			designation = scan.nextLine();
			System.out.println("Please enter new Employee Sex");
			sex = scan.next();
			System.out.println("Please enter new Employee Age");
			age = scan.nextInt();

			employee = new Employee();
			employee.setAddress(address);
			employee.setAge(age);
			employee.setDesignation(designation);
			employee.setName(name);
			employee.setSex(sex);
			employee.setId(id);
			employee = registrationService.updateEmployeeForEmployeeId(employee);
			employees.add(employee);
			break;
		default:
			System.out.println("You have enter wrong option, to continue enter Y/N and the chose correct option");
			return;
		}
		BasicUtilFunction.responseMapper(employees, processnumber);
	}
}
