package org.sid.lightecomv1.dao;

import org.sid.lightecomv1.entities.Beneficiaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface BeneciaireRepository extends JpaRepository<Beneficiaire, Long> {

}
