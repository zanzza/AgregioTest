package com.agregio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agregio.entity.Blocs;
import com.agregio.entity.Offre;
import com.agregio.repository.OffreRepository;

@Service
public class EnergieService {
	@Autowired
	OffreRepository offreRepository;
	
	public String makeOffer ( ) {
		Offre offre = new Offre();
		offre.setBlocs(Blocs.BLOC_1);
		offre.setMegawat(23);
		Long id = offreRepository.save(offre).getId();
		return offreRepository.findById(id).get().toString();
	}

}
