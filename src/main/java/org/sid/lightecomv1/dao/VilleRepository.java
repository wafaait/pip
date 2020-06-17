package org.sid.lightecomv1.dao;

import org.sid.lightecomv1.entities.Beneficiaire;
import org.sid.lightecomv1.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface VilleRepository extends JpaRepository<Ville, Long> {

}
