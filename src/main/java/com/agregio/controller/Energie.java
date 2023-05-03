package com.agregio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agregio.service.EnergieService;

@RestController
public class Energie {
	
	@Autowired
	EnergieService energieService;
	
	@GetMapping("/")
	public String index() {
		return energieService.makeOffer();
	}

}
