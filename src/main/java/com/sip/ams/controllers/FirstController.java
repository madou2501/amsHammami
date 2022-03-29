package com.sip.ams.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.entities.Etudiant;

@Controller	
public class FirstController {
	
	private ArrayList<Etudiant> students = new ArrayList<>();

	@RequestMapping("/first")
	public String home(Model m)
	{
		String nom ="Mahdi Hammami";
		String universite ="EPAMS";
		String email ="mahdihammami2501@gmail.com";
		String tlf ="+21696742113";
	
		m.addAttribute("name", nom);
		m.addAttribute( "myUniversite",universite);
		m.addAttribute( "email",email);
		m.addAttribute( "tlf",tlf);
		
		ArrayList<String> cours = new ArrayList<>();
		cours.add("Java OCA");
		cours.add("Java OCP");
		cours.add("Spring");
		cours.add("Microservices");
		
		m.addAttribute( "cours",cours);
		
		
		
		
		
		
			
		return "/home/app";
	}
	
	@RequestMapping("/list")
	public String etudiants(Model m )
	{
		
//		students.add(new Etudiant("Mahdi",25,"mahdihammami2501@gmail.com","testour",96742113));
//		students.add(new Etudiant("Tahar",60,"TaharHamami1@gmail.com","testour",969989741));
//		students.add(new Etudiant("Nouha",20,"NouhaHamami1@gmail.com","testour",969555894));
//		
//		
		
		m.addAttribute("students", students);
		
		
		
			
		return "/home//etudiants";
	}
	@RequestMapping("/add")
	public String addEtudiant(Model m)
	{
		return "home/addStudent";
	}
	
	//methode delete
	@GetMapping("/delete/{email}")
	//@ResponseBody
	public String deleteEtudiant(@PathVariable("email")String mail)
	{
		Etudiant temp=null;
		for(Etudiant e : students)
		{
			if(e.getEmail().equals(mail))
			{
				temp = e;
			}
		}
		students.remove(temp);
		return "redirect:../list";
	}
	
	
	@PostMapping("/save")
	//@ResponseBody
	public String saveEtudiant(
			@RequestParam("Nom")String nom,
			@RequestParam("email")String email,
			@RequestParam("adresse")String adresse,
			@RequestParam("age")int age,
			@RequestParam("tel")int tel
			
			)
	{
		//return "home/addStudent";
		Etudiant temp = new Etudiant(nom,age,email,adresse,tel);
		//return "vous avez taper :"+nom+" "+email+" "+adresse+" "+age+" "+tel;
		students.add(temp);
		//return temp.toString();
		return "redirect:list";
	}
	

}
