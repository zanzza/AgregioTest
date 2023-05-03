package com.agregio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.agregio.entity.Offre; 

@Repository
public interface OffreRepository extends CrudRepository<Offre, Long>{

}
