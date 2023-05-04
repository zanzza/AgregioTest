package com.agregio.repository;

import com.agregio.entity.Blocs;
import com.agregio.entity.Marche;
import com.agregio.entity.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.agregio.entity.Offre;

import java.util.List;

@Repository
public interface OffreRepository extends CrudRepository<Offre, Long>{

    Offre findOneByNameAndMarche(String name, Marche marche);

    List<Offre> findAll();

    List<Offre> findAllByName(String name);
}
