package com.agregio.service;

import com.agregio.entity.Marche;
import com.agregio.entity.Offre;
import com.agregio.entity.Parc;
import com.agregio.entity.Type;
import com.agregio.repository.OffreRepository;
import com.agregio.repository.ParcRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcService {
    private static final Logger LOGGER = LogManager.getLogger(ParcService.class);
    @Autowired
    ParcRepository repository;

    @Autowired
    OffreRepository offreRepository;

    public void createParc(String name, String type, int megawatt) {
            Type typeEnergy = Type.getValue(type);
            if (typeEnergy != null) {
                Parc parc = repository.findOneByNameAndType(name, typeEnergy);
                if (parc == null) {
                    parc = new Parc();
                    parc.setName(name);
                    parc.setType(typeEnergy);
                }
                parc.setMegawatt(megawatt);
                repository.save(parc);

                LOGGER.info("Parc bien enregistré");
            }

    }

    public List<Parc> getParcs(String name){
        return repository.findAllByName(name);
    }

    public void postParcToOffer(String name, String type, String offreName, String marche) {
        Marche marcheOffre = Marche.getValue(marche);
        Type typeEnergy = Type.getValue(type);
        if (typeEnergy != null) {
            Parc parc = repository.findOneByNameAndType(name, typeEnergy);
            Offre offre = offreRepository.findOneByNameAndMarche(offreName, marcheOffre);
            if (parc != null && offre != null) {

                offre.getParcs().add(parc);
                offreRepository.save(offre);

                logger.info("Parc bien associé a une offre");
            }
        }
    }
}
