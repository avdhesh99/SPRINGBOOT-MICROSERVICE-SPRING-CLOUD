package com.error.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.error.exception.EmployeeException;

//https://www.javacodegeeks.com/2016/01/exception-handling-spring-restful-web-service.html

@RestController
public class EmployeeController {
 
	@RequestMapping(value = "/{firstName}", method = RequestMethod.GET)
	public ResponseEntity<Employee> showMessage(
			@PathVariable("firstName") String firstName,
			@RequestParam(value = "empId", required = false, defaultValue = "00000") final String empId) throws EmployeeException {
 
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setName(firstName);
 
		if (isNumeric(firstName)) {
			throw new EmployeeException("Invalid employee name requested");
		}
 
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
 
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setReasonCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
	
	public boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	} 
}