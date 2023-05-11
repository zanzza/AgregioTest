package com.agregio.service;

import com.agregio.entity.Marche;
import com.agregio.entity.Offre;
import com.agregio.entity.Parc;
import com.agregio.entity.Type;
import com.agregio.repository.OffreRepository;
import com.agregio.repository.ParcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParcServiceTest {

    ParcService parcService;
    @Mock
    ParcRepository parcRepository;
    @Mock
    OffreRepository offreRepository;

    @BeforeEach
    public void init() {
        this.parcService = new ParcService(parcRepository, offreRepository);
    }

    @Test
    void createParc() {
        Parc parc = new Parc();
        parc.setType(Type.EOLIEN);
        parc.setName("TEST_NAME");
        parc.setMegawatt(12);
        when(parcRepository.findOneByNameAndType(eq("TEST_NAME"), eq(Type.EOLIEN))).thenReturn(parc);

        parcService.createParc("TEST_NAME", Type.EOLIEN.name(), 12);

        Mockito.verify(parcRepository, Mockito.times(1)).save(parc);

    }

    @Test
    void createParcWhoNotExist() {
        Parc parc = new Parc();
        parc.setType(Type.EOLIEN);
        parc.setName("TEST_NAME");
        parc.setMegawatt(12);
        when(parcRepository.findOneByNameAndType(eq("TEST_NAME"), eq(Type.EOLIEN))).thenReturn(null);

        parcService.createParc("TEST_NAME", Type.EOLIEN.name(), 12);

        Mockito.verify(parcRepository, Mockito.times(1)).save(parc);

    }

    @Test
    void getParcs() {

        String testName = "TEST_NAME";
        when(parcRepository.findAllByName(eq(testName))).thenReturn(new ArrayList<>());
        parcService.getParcs(testName);

        Mockito.verify(parcRepository, Mockito.times(1)).findAllByName(testName);

    }

    @Test
    void postParcToOffer() {
        Parc parc = new Parc();
        parc.setType(Type.EOLIEN);
        parc.setName("TEST_NAME");
        parc.setMegawatt(12);

        Offre offre = new Offre();
        offre.setPrix(12);
        offre.setName("TEST_NAME");
        offre.setMarche(Marche.PRIMAIRE);

        when(parcRepository.findOneByNameAndType(eq("TEST_NAME"), eq(Type.EOLIEN))).thenReturn(parc);

        when(offreRepository.findOneByNameAndMarche(eq("TEST_NAME"), eq(Marche.PRIMAIRE))).thenReturn(offre);

        parcService.postParcToOffer("TEST_NAME", Type.EOLIEN.name(),
                "TEST_NAME", Marche.PRIMAIRE.name());

        List<Parc> parcs = new ArrayList<>();
        parcs.add(parc);
        offre.setParcs(parcs);

        Mockito.verify(offreRepository, Mockito.times(1)).save(offre);


    }

    @Test
    void postParcToOfferWhoNotExist() {
        Parc parc = new Parc();
        parc.setType(Type.EOLIEN);
        parc.setName("TEST_NAME");
        parc.setMegawatt(12);

        Offre offre = new Offre();
        offre.setPrix(12);
        offre.setName("TEST_NAME");
        offre.setMarche(Marche.PRIMAIRE);

        when(parcRepository.findOneByNameAndType(eq("TEST_NAME"), eq(Type.EOLIEN))).thenReturn(parc);

        when(offreRepository.findOneByNameAndMarche(eq("TEST_NAME"), eq(Marche.PRIMAIRE))).thenReturn(null);

        parcService.postParcToOffer("TEST_NAME", Type.EOLIEN.name(),
                "TEST_NAME", Marche.PRIMAIRE.name());

        List<Parc> parcs = new ArrayList<>();
        parcs.add(parc);
        offre.setParcs(parcs);

        Mockito.verify(offreRepository, Mockito.times(0)).save(offre);


    }

    @Test
    void postParcWhoNotExistToOffer() {
        Parc parc = new Parc();
        parc.setType(Type.EOLIEN);
        parc.setName("TEST_NAME");
        parc.setMegawatt(12);

        Offre offre = new Offre();
        offre.setPrix(12);
        offre.setName("TEST_NAME");
        offre.setMarche(Marche.PRIMAIRE);

        when(parcRepository.findOneByNameAndType(eq("TEST_NAME"), eq(Type.EOLIEN))).thenReturn(null);

        when(offreRepository.findOneByNameAndMarche(eq("TEST_NAME"), eq(Marche.PRIMAIRE))).thenReturn(offre);

        parcService.postParcToOffer("TEST_NAME", Type.EOLIEN.name(),
                "TEST_NAME", Marche.PRIMAIRE.name());

        List<Parc> parcs = new ArrayList<>();
        parcs.add(parc);
        offre.setParcs(parcs);

        Mockito.verify(offreRepository, Mockito.times(0)).save(offre);


    }
}