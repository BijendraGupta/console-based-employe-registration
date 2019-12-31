package console.based.employee.registration.application.service;

import java.util.List;

import console.based.employee.registration.application.dao.RegistrationDao;
import console.based.employee.registration.application.dao.RegistrationDaoImpl;
import console.based.employee.registration.application.model.Employee;

public class RegistrationServiceImpl implements RegistrationService {

	private RegistrationDao registrationDao;

	public RegistrationDao getRegistrationDao() {
		return registrationDao;
	}

	public RegistrationServiceImpl() {
		registrationDao = new RegistrationDaoImpl();
	}

	@Override
	public Employee doRegistration(Employee employee) {
		return registrationDao.doRegistration(employee);
	}

	@Override
	public Employee getEmployeeForEmpployeeId(int employeeId) {
		return registrationDao.getEmployeeForEmpployeeId(employeeId);
	}

	@Override
	public Employee deleteEmployee(int employeeId) {
		return registrationDao.deleteEmployee(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return registrationDao.getAllEmployees();
	}

	@Override
	public Employee updateEmployeeForEmployeeId(Employee employee) {
		return registrationDao.updateEmployeeForEmployeeId(employee);
	}

}
