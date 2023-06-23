package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.entity.Users_In_library;
import com.books.service.Librarian_service;

@RestController
public class Librarian_Controller {

	@Autowired
	private Librarian_service service;
	
	

	@GetMapping("All_users")
	public List<Users_In_library> get_users() {
		System.out.println("In the all users..");
		return service.get_users();
	}

	@PostMapping("Insert_User")
	public String create_User(@RequestBody Users_In_library user) {
		return service.create_User(user);
	}

	@PutMapping("update")
	public String update_User(@RequestBody Users_In_library user) {
		return service.update_User(user);

	}

	// it is not running
	@DeleteMapping("Delete_User/{id}")
	public String delete_User(@PathVariable("id") int id) {
		return service.delete_User(id);
	}

	@GetMapping("get_First_Name")
	public List<Users_In_library> get_First_Name(@RequestBody Users_In_library user) {
		return service.get_First_Name(user);
	}

	@GetMapping("Bonus_less_than")
	public List<Users_In_library> bonus_less_than_200() {
		return service.bonus_less_than_200();
	}

	// To get records having salary less than 2000
	// cr.add(Restrictions.lt("salary", 2000));

	@GetMapping("rows")
	public List<Users_In_library> row_cout() {
		return service.row_cout();
	}

	@GetMapping("name_Desc_order")
	public List<Users_In_library> Ordedby_name_DESC() {
		return service.Ordedby_name_DESC();
	}

	@GetMapping("sum_of_due")
	public List<Users_In_library> sum_of_bonus() {
		return service.sum_of_bonus();
	}

	@GetMapping("max_bonus")
	public List<Users_In_library> max_bonus() {
		return service.max_bonus();
	}
	
	@GetMapping("Check_Database_isEmpty")
	public boolean  isEmepty() {
		return service.isEmepty();
	}
	@GetMapping("List_of_Field")
	public List<Users_In_library>  list_of_Field()
	{
		return service.list_of_Field();
	}
	
	@GetMapping("Particular_Field")
	public List<Users_In_library> particular_field_count()
	{
		return service.particular_field_count();
	}
	

	@GetMapping("panalty")
	public List<Integer> Extra_Charge_of_Due()
	{
	return service.Extra_Charge_of_Due();
	}
	
	@GetMapping("distinct_name_of_librarian")
	public List<Users_In_library> distinct_name_of_librarian()
	{
		return service.distinct_name_of_librarian();
	}
	
	@GetMapping("Group_by_Name_Field")
	public List<Users_In_library> group_by_alias_usin_Name_Field()
	{
		return service.group_by_alias_usin_Name_Field();
	}
	
	@GetMapping("DetachedCriteria_Query_Date")
	public List<Users_In_library> DetachedCriteria_Query_Date()
	{
		return service.DetachedCriteria_Query_Date();
		
	}
	
	@GetMapping("SubQueries_on_Due_Field")
	public List<Users_In_library> sub_query_using_Dispacter()
	{
		return service. sub_query_using_Dispacter();
	}
}
