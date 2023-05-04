package com.agregio.repository;

import com.agregio.entity.Offre;
import com.agregio.entity.Parc;
import com.agregio.entity.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcRepository extends CrudRepository<Parc, Long> {

    Parc findOneByNameAndType(String name, Type type);

    List<Parc> findAllByName(String name);
}
