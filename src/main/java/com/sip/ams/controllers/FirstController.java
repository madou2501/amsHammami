package com.sip.ams.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.entities.Etudiant;

@Controller	
public class FirstController {

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
		
		
		
		
		
		
			
		return "/home//app";
	}
	
	@RequestMapping("/list")
	public String etudiants(Model m )
	{
		ArrayList<Etudiant> students = new ArrayList<>();	
		students.add(new Etudiant("Mahdi",25,"mahdihammami2501@gmail.com","testour",96742113));
		students.add(new Etudiant("Tahar",60,"TaharHamami1@gmail.com","testour",969989741));
		students.add(new Etudiant("Nouha",20,"NouhaHamami1@gmail.com","testour",969555894));
		
		
		
		m.addAttribute("students", students);
		
		
		
			
		return "/home//etudiants";
	}
	@RequestMapping("/add")
	public String addEtudiant(Model m)
	{
		return "home/addStudent";
	}
	

}
