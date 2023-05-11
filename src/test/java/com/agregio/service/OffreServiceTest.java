package com.agregio.service;

import com.agregio.entity.Blocs;
import com.agregio.entity.Marche;
import com.agregio.entity.Offre;
import com.agregio.repository.OffreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OffreServiceTest {


    @Mock
    OffreRepository repository;


    @BeforeEach
    public void init() {
        this.offreService = new OffreService(repository);
    }

    OffreService offreService;

    @Test
    void createOffer() {
        Offre offre = new Offre();
        offre.setName("TEST_NAME");
        offre.setPrix(12);
        offre.setMarche(Marche.PRIMAIRE);
        when(repository.findOneByNameAndMarche(eq("TEST_NAME"), eq(Marche.PRIMAIRE))).thenReturn(offre);

        offreService.createOffer("TEST_NAME", "PRIMAIRE", 12);

        Mockito.verify(repository, Mockito.times(1)).save(offre);
    }

    @Test
    void createOfferWhoNotExist() {
        Offre offre = new Offre();
        offre.setName("TEST_NAME");
        offre.setPrix(12);
        offre.setMarche(Marche.PRIMAIRE);
        when(repository.findOneByNameAndMarche(eq("TEST_NAME"), eq(Marche.PRIMAIRE))).thenReturn(null);

        offreService.createOffer("TEST_NAME", "PRIMAIRE", 12);

        Mockito.verify(repository, Mockito.times(1)).save(offre);
    }

    @Test
    void getAllOfferFromName() {
        when(repository.findAllByName(eq("TEST_NAME"))).thenReturn(new ArrayList<>());

        offreService.getAllOfferFromName("TEST_NAME");

        Mockito.verify(repository, Mockito.times(1)).findAllByName("TEST_NAME");
    }

    @Test
    void getAllOffer() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        offreService.getAllOffer();

        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    void addBlocOffer() {
        Offre offre = new Offre();
        offre.setName("TEST_NAME");
        offre.setBloc(Collections.singleton(Blocs.BLOC_1));
        offre.setMarche(Marche.PRIMAIRE);
        when(repository.findOneByNameAndMarche(eq("TEST_NAME"), eq(Marche.PRIMAIRE))).thenReturn(offre);

        offreService.addBlocOffer("TEST_NAME", "PRIMAIRE", "BLOC_1");

        Mockito.verify(repository, Mockito.times(1)).save(offre);
    }

    @Test
    void addBlocOfferWhoNotExist() {
        Offre offre = new Offre();
        offre.setName("TEST_NAME");
        offre.setBloc(Collections.singleton(Blocs.BLOC_1));
        offre.setMarche(Marche.PRIMAIRE);
        when(repository.findOneByNameAndMarche(eq("TEST_NAME"), eq(Marche.PRIMAIRE))).thenReturn(null);

        offreService.addBlocOffer("TEST_NAME", "PRIMAIRE", "BLOC_1");

        Mockito.verify(repository, Mockito.times(1)).save(offre);
    }
}