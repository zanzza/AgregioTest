package com.agregio.controller;

import com.agregio.entity.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.agregio.service.OffreService;

import java.util.List;

@RestController()
public class OffreController {
	
	@Autowired
	OffreService offreService;
	
	@PostMapping("/makeOffer/{name}/{marche}/{prix}")
	public String makeOffer(@PathVariable String name,
							@PathVariable String marche,
							@PathVariable int prix) {
		offreService.createOffer(name, marche, prix);
		return "Offre créée";
	}

	@PostMapping("/makeOffer/bloc/{name}/{marche}/{bloc}")
	public String addBlockToOffer(@PathVariable String name,
							@PathVariable String marche,
							@PathVariable String bloc) {
		offreService.addBlocOffer(name, marche, bloc);
		return "Offre créée";
	}

	@GetMapping("/getAllOffer/{name}")
	public List<Offre> getAllOfferBySeller(@PathVariable String name) {
		return offreService.getAllOfferFromName(name);
	}


}
