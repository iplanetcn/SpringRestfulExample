package com.phenix.springrestful.controller;

import com.phenix.springrestful.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	public static final String DUMMY_EMP = "/rest/emp/dummy";
	public static final String GET_EMP = "/rest/emp/{id}";
	public static final String GET_ALL_EMP = "/rest/emps";
	public static final String CREATE_EMP = "/rest/emp/create";
	public static final String DELETE_EMP = "/rest/emp/delete/{id}";

	//Map to store employees, ideally we should use database
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

	@RequestMapping(value = DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody
	Employee getDummyEmployee() {
		logger.info("Start getDummyEmployee");
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setCreatedDate(new Date());
		empData.put(9999, emp);
		return emp;
	}

	@RequestMapping(value = GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID="+empId);

		return empData.get(empId);
	}

	@RequestMapping(value = GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody
	List<Employee> getAllEmployees() {
		logger.info("Start getAllEmployees.");
		List<Employee> emps = new ArrayList<Employee>();
		Set<Integer> empIdKeys = empData.keySet();
		for(Integer i : empIdKeys){
			emps.add(empData.get(i));
		}
		return emps;
	}

	@RequestMapping(value = CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Start createEmployee.");
		emp.setCreatedDate(new Date());
		empData.put(emp.getId(), emp);
		return emp;
	}

	@RequestMapping(value = DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
		logger.info("Start deleteEmployee.");
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}
}