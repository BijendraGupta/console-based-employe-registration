/**
 * 
 */
package console.based.employee.registration.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import console.based.employee.registration.application.config.MySqlJDBC;
import console.based.employee.registration.application.model.Employee;

/**
 * @author Bijendra
 *
 */
public class RegistrationDaoImpl implements RegistrationDao {

	private Connection mySqlJDBC;


	public Connection getMySqlJDBC() {
		return mySqlJDBC;
	}
	
	public RegistrationDaoImpl() {
		mySqlJDBC = MySqlJDBC.getMySqlJDBC();
	}

	@Override
	public Employee doRegistration(Employee employee) {
		Connection c = mySqlJDBC;

		PreparedStatement ps = null;

		int recordCounter = 0;

		try {

			ps = c.prepareStatement(
					"INSERT INTO `test`.`employee` (`ID`,`NAME`,`ADDRESS`,`DESIGNATION`,`SEX`,`AGE`) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, employee.getId().toString());
			ps.setString(2, employee.getName().toString());
			ps.setString(3, employee.getAddress().toString());
			ps.setString(4, employee.getDesignation().toString());
			ps.setString(5, employee.getSex().toString());
			ps.setString(6, employee.getAge().toString());
			recordCounter = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		if (recordCounter == 0)
			return null;
		return employee;
	}

	@Override
	public Employee getEmployeeForEmpployeeId(int employeeId) {
		Connection con = mySqlJDBC;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = new Employee();

		try {

			ps = con.prepareStatement("select * from employee where id=?");
			ps.setString(1, String.valueOf(employeeId));
			rs = ps.executeQuery();
			while (rs.next()) {
				employee.setAddress(rs.getString(3));
				employee.setId(Integer.parseInt(rs.getString(1)));
				employee.setAge(Integer.parseInt(rs.getString(6)));
				employee.setName(rs.getString(2));
				employee.setSex(rs.getString(5));
				employee.setDesignation(rs.getString(4));
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return employee;
	}

	@Override
	public Employee deleteEmployee(int employeeId) {
		Connection c = mySqlJDBC;

		PreparedStatement ps = null;

		int recordCounter = 0;

		try {

			ps = c.prepareStatement("delete from `test`.`employee` where id=?");
			ps.setString(1, String.valueOf(employeeId));
			recordCounter = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		if (recordCounter == 0)
			return null;
		Employee employee = new Employee();
		employee.setId(employeeId);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Connection con = mySqlJDBC;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = new Employee();
		List<Employee> employees = new ArrayList<Employee>();
		try {

			ps = con.prepareStatement("select * from employee ");
			rs = ps.executeQuery();
			while (rs.next()) {
				employee.setAddress(rs.getString(3));
				employee.setId(Integer.parseInt(rs.getString(1)));
				employee.setAge(Integer.parseInt(rs.getString(6)));
				employee.setName(rs.getString(2));
				employee.setSex(rs.getString(5));
				employee.setDesignation(rs.getString(4));
				employees.add(employee);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return employees;
	}

	@Override
	public Employee updateEmployeeForEmployeeId(Employee employee) {
		Connection c = mySqlJDBC;

		PreparedStatement ps = null;

		int recordCounter = 0;

		try {

			ps = c.prepareStatement(
					"update   `test`.`employee`  set  `NAME`=?,`ADDRESS`=?,`DESIGNATION`=?,`SEX`=?,`AGE`=? ");
			ps.setString(1, employee.getName().toString());
			ps.setString(2, employee.getAddress().toString());
			ps.setString(3, employee.getDesignation().toString());
			ps.setString(4, employee.getSex().toString());
			ps.setString(5, employee.getAge().toString());
			recordCounter = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		if (recordCounter == 0)
			return null;
		return employee;
	}

}
