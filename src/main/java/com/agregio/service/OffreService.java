package com.agregio.service;

import com.agregio.entity.Blocs;
import com.agregio.entity.Marche;
import com.agregio.entity.Offre;
import com.agregio.repository.OffreRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OffreService {
	private static final Logger LOGGER = LogManager.getLogger(OffreService.class);
	public OffreService(OffreRepository offreRepository) {
		this.offreRepository = offreRepository;
	}

	OffreRepository offreRepository;
	
	public void createOffer(String name, String  marche, int prix ) {
		Marche marcheOffre = Marche.getValue(marche);
		if (marcheOffre != null) {
			Offre offre = offreRepository.findOneByNameAndMarche(name, marcheOffre);
			if (offre == null) {
				offre = new Offre();
				offre.setName(name);
				offre.setMarche(marcheOffre);
			}
			offre.setPrix(prix);
			offreRepository.save(offre);
			LOGGER.info("Offre bien enregistré");
		}
	}

	public List<Offre> getAllOfferFromName(String name ) {
		return offreRepository.findAllByName(name);
	}

	public List<Offre> getAllOffer () {
		return offreRepository.findAll();
	}


	public void addBlocOffer(String name, String marche, String bloc) {
		Marche marcheOffre = Marche.getValue(marche);
		Blocs blocOffre = Blocs.getValue(bloc);
		if (marcheOffre != null && blocOffre != null) {
			Offre offre = offreRepository.findOneByNameAndMarche(name, marcheOffre);
			Set<Blocs> blocs = new HashSet<>();
			if (offre == null) {
				offre = new Offre();
				offre.setName(name);
				offre.setMarche(marcheOffre);
			} else {
				Set<Blocs> offreBloc = offre.getBloc();
				if (offreBloc != null) {
					blocs.addAll(offreBloc);
				}
			}
			blocs.add(blocOffre);
			offre.setBloc(blocs);
			offreRepository.save(offre);

			LOGGER.info("Offre bien enregistré");
		}

	}
}
