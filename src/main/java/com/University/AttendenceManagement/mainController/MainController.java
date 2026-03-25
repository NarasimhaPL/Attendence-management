package com.University.AttendenceManagement.mainController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.University.AttendenceManagement.DetailService.DetailService;

@CrossOrigin("*")
@RestController
@RequestMapping("Student/details")
public class MainController {
	
	DetailService service;
	MainController(DetailService service){
		this.service=service;
	}
	
	@GetMapping("/{name}/{USN}/{SubCode}")
	public String GetDetails(@PathVariable String name,@PathVariable  String USN,@PathVariable  String SubCode) {
		return service.setDetails(name,USN,SubCode);
	}
	@GetMapping("/")
	public String greet() {
		return "welcome";
	}

}
