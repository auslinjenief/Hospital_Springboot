package com.AJ.Hostpital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PatientController {
	@Autowired
	private PatientRepo repo;
	
	@GetMapping("/") //fetch all
	public List<PatientModel> Home()
	{
		return repo.AllPatient();
	}
	
	@GetMapping("/get/{id}") //fetch one
	public PatientModel PatientOne(@PathVariable int id)
	{
		return repo.OnePatient(id);
	}
	
	@PostMapping("/post") //insert
	public void patientCreate(@RequestBody PatientModel p) 
	{
		 repo.createPatient(p.getName(),p.getAge(),p.getGender());
	}
	
	@PutMapping("/put/{id}") // update
	public void patientupdate(@PathVariable int id,@RequestBody PatientModel p)
	{
		repo.patientupdate(id,p.getName(),p.getAge(),p.getGender());
	}
   
	@DeleteMapping("/delete/{id}") //delete
	public void Deletepatient(@PathVariable int id)
	{
		repo.patientDelete(id);
	}
}
