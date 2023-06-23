package com.books.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.Librarian_Dao;
import com.books.entity.Users_In_library;

@Service
public class Librarian_service {

	@Autowired
	private Librarian_Dao dao;

	public List<Users_In_library> get_users() {
		return dao.get_users();
	}

	public String create_User(Users_In_library user) {
		return dao.create_User(user);
	}

	public String update_User(Users_In_library user) {
		return dao.update_User(user);
	}

	public String delete_User(int id) {
		return dao.delete_User(id);

	}

	public List<Users_In_library> get_First_Name(Users_In_library user) {

		return dao.get_First_Name(user);

	}

	public List<Users_In_library> bonus_less_than_200() {
		return dao.bonus_less_than_200();
	}

	public List<Users_In_library> row_cout() {
		return dao.row_cout();
	}

	public List<Users_In_library> Ordedby_name_DESC() {
		return dao.Ordedby_name_DESC();
	}

	public List<Users_In_library> sum_of_bonus() {
		return dao.sum_of_bonus();
	}

	public List<Users_In_library> max_bonus() {
		return dao.max_bonus();
	}

	public boolean isEmepty() {
		return dao.isEmepty();
	}

	public List<Users_In_library> list_of_Field() {
		return dao.list_of_Field();
	}

	public List<Users_In_library> particular_field_count() {
		return dao.particular_field_count();
	}
	/*
	 * @Service public class EmployeeService {
	 * 
	 * @Autowired private EmployeeDAO employeeDAO;
	 * 
	 * public void incrementSalary(int employeeId, double incrementPercentage) {
	 * Employee employee = employeeDAO.getEmployeeById(employeeId); double
	 * salaryIncrement = employee.getSalary() * incrementPercentage / 100.0; double
	 * newSalary = employee.getSalary() + salaryIncrement;
	 * employee.setSalary(newSalary); employeeDAO.updateEmployee(employee); } }
	 */

	// Stream<Product> filtered_data = list.stream().filter();
	// extra_Charge_of_Due.stream().filter(p -> p.getDue_of_Late_Submit() > 20000);
	public List<Integer> Extra_Charge_of_Due() {
		ArrayList<Integer> list = new ArrayList<>();

		List<Users_In_library> extra_Charge_of_Due = dao.Extra_Charge_of_Due();

		for (Users_In_library users_In_library : extra_Charge_of_Due) {
			int dem = users_In_library.getDue_of_Late_Submit() + 100;
			list.add(dem);
		}

		return list;

	}

	public List<Users_In_library> distinct_name_of_librarian()
	{
		return dao.distinct_name_of_librarian();
	}
	
	public List<Users_In_library> group_by_alias_usin_Name_Field()
	{
		return dao.group_by_alias_usin_Name_Field();
	}
	
	public List<Users_In_library> DetachedCriteria_Query_Date()
	{
		return dao.DetachedCriteria_Query_Date();
	}
	
	public List<Users_In_library> sub_query_using_Dispacter()
	{
		return dao.sub_query_using_Dispacter();
	}
}
