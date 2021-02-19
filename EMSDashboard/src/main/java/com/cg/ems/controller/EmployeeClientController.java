package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cg.ems.entity.EmployeeInfo;


@RestController
@CrossOrigin
public class EmployeeClientController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public EmployeeInfo getemployeeRecord(@PathVariable int id)
	{
		String url="http://localhost:7004/employee/find/"+id;
		return restTemplate.getForObject(url, EmployeeInfo.class);
	}

	@PostMapping("/addEmployee")
	public String addemployeeRecord(@RequestBody EmployeeInfo emp)
	{
		String url="http://localhost:7004/addEmployee/";
		return restTemplate.postForObject(url, emp, String.class);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<EmployeeInfo>> getAllEmployeeRecord()
	{   
		HttpHeaders headers=new HttpHeaders();
		String url="http://localhost:7004/employee/findAll";
        HttpEntity<List<EmployeeInfo>> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List<EmployeeInfo>> employeeResponse= restTemplate.exchange(url,
        		HttpMethod.GET,requestEntity,
				new ParameterizedTypeReference<List<EmployeeInfo>>() {
        });
       // List<EmployeeInfo> employeesList = employeeResponse.getBody();
		return employeeResponse;

		//return restTemplate.getForObject(url, List<EmployeeInfo.class>);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployeeRecord(@PathVariable int id)
	{  
		HttpHeaders headers=new HttpHeaders();
		String url="http://localhost:7004/employee/delete/"+id;
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		return restTemplate.exchange(url,HttpMethod.DELETE, requestEntity,String.class );
		
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<String> updateEemployeeRecord(@RequestBody EmployeeInfo emp)
	{
		HttpHeaders headers=new HttpHeaders();
		String url="http://localhost:7004/updateEmployee/";
        HttpEntity<EmployeeInfo> requestEntity = new HttpEntity<>(emp, headers);
		return restTemplate.exchange(url,HttpMethod.PUT, requestEntity,String.class,emp );	
		}
	
}