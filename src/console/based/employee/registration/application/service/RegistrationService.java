/**
 * 
 */
package console.based.employee.registration.application.service;

import java.util.List;

import console.based.employee.registration.application.model.Employee;

/**
 * @author Bijendra
 *
 */
public interface RegistrationService {

	public Employee doRegistration(Employee employee);

	public Employee getEmployeeForEmpployeeId(int employeeId);

	public Employee deleteEmployee(int employeeId);

	public List<Employee> getAllEmployees();

	public Employee updateEmployeeForEmployeeId(Employee employee);
}
