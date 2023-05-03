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
	
	public String makeOffer ( String bloc, int megawat ) {
		Offre offre = new Offre();
		offre.setBlocs(Blocs.valueOf(bloc));
		offre.setMegawat(megawat);
		Long id = offreRepository.save(offre).getId();
		return offreRepository.findById(id).get().toString();
	}

}
