package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.example.demo.model.StDetails;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/Student")
public class MyController {

	@Autowired
	private StService service;

	@Autowired
	private StudentResponse response;

	@PostMapping("/saveDetails")
	public ResponseEntity<StudentResponse> addStudent(@Valid @RequestBody StDetails details) {
		StDetails stDetails = service.saveDetails(details);
		if (stDetails != null) {
			response.setResponsecode(200);
			response.setError(false);
			response.setDtos(Arrays.asList(stDetails));
			response.setMessage("Data Saved");
			return new ResponseEntity<StudentResponse>(response, HttpStatus.OK);
		} else {
			response.setResponsecode(401);
			response.setError(true);
			response.setMessage("Details Not Saved");
			response.setDtos(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("getbyId/{id}")
	public ResponseEntity<StudentResponse> getStudent(@PathVariable("id") int id) {
		StDetails stDetails = service.getByid(id);
		if (stDetails != null) {
			response.setResponsecode(200);
			response.setError(false);
			response.setDtos(Arrays.asList(stDetails));
			return new ResponseEntity<StudentResponse>(response, HttpStatus.OK);
		} else {
			response.setResponsecode(401);
			response.setError(true);
			response.setDtos(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("updateStudent/{id}")
	public ResponseEntity<StudentResponse> updateRecharge(@Valid @PathVariable("id") int id,
			@RequestBody StDetails dto) {
		StDetails dto22 = service.updateRecharge(id, dto);
		if (dto22 != null) {
			response.setResponsecode(200);
			response.setError(false);
			response.setDtos(Arrays.asList(dto22));

			return new ResponseEntity<StudentResponse>(response, HttpStatus.OK);
		} else {
			response.setResponsecode(404);
			response.setError(true);
			response.setDtos(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("deletebyid/{id}")
	public ResponseEntity<StudentResponse> deleteByid(@PathVariable("id") int id) {
		StDetails dto23 = service.deleteStudent(id);
		if (dto23 != null) {
			response.setResponsecode(200);
			response.setError(false);
			response.setMessage("Deleted Sucessfully");
			response.setDtos(Arrays.asList(dto23));

			return new ResponseEntity<StudentResponse>(response, HttpStatus.OK);
		} else {
			response.setResponsecode(404);
			response.setError(true);
			response.setDtos(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/listofrecords")
	public List<StDetails> getAllDetails() {
		return service.getAllDetls();
	}
	
	
	@GetMapping("/sortingSize/{pagenumber}/{pagesize}")
	public Page<StDetails> studentPagination(@PathVariable Integer pagenumber, @PathVariable Integer pagesize ){
		
		return service.getStudentPagination(pagenumber,pagesize,null );
	}
	
	@GetMapping("/sortingSize/{pagenumber}/{pagesize}/{sortProperty}")
	public Page<StDetails> studentPagination(
			@PathVariable Integer pagenumber, 
			@PathVariable Integer pagesize,
			@PathVariable String sortProperty){
		
		return service.getStudentPagination(pagenumber,pagesize,sortProperty );
	}

	
	@GetMapping("/Sortbyjava8")
	public List<StDetails> sorByJavaEigh(){
		return service.sortByjavaEi();
	}
	
	@GetMapping("/SortbyPercent")
	public List<StDetails> sortByPercentage(){
		return service.sortBypercent();
		
	}
	
	
//	@GetMapping("/{field}")
//	public ResponseEntity<StudentResponse> getAllStByRollk(@PathVariable String field) {
//		List<StDetails> findsort = service.getAllStByRoll(field);
//
//		return new ResponseEntity<>(findsort.size(), field);
//	}

//	@GetMapping("/sortAllRec/{sortBy}")
//	public ResponseEntity<StudentResponse> getAllStByRoll(
//			@RequestParam(value = "sortBy", defaultValue = "rollno", required = true) String sortBy) {
//		StDetails responses = this.service.getAllStByRoll(sortBy);
//		if (response != null) {
//			response.setResponsecode(200);
//			response.setError(false);
//			response.setMessage("Sorted data is");
//			response.setDtos(Arrays.asList(responses));
//
//			return new ResponseEntity<StudentResponse>(response, HttpStatus.OK);
//		} else {
//			response.setResponsecode(404);
//			response.setError(true);
//			response.setDtos(null);
//			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//
//		}
//	}

//	@GetMapping("/sortByRollNo/{rollno}")
//	public ResponseEntity<StudentResponse> getByrollno(@PathVariable int rollno){
//		StDetails stDetails = this.service.getByrollno
//	}
}
