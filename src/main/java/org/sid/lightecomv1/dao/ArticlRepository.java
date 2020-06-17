package org.sid.lightecomv1.dao;


import org.sid.lightecomv1.entities.Articl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface ArticlRepository extends JpaRepository<Articl, Long> {
    @RestResource(path = "/selectedArticls")
    public List<Articl> findBySelectedIsTrue();
    @RestResource(path = "/chercher")
    public List<Articl> findByNameContains(@Param("mc") String mc);
    @RestResource(path = "/dispoArticls")
    public List<Articl> findByAvailableIsTrue();
    @RestResource(path = "/chercherPage")
    public Page<Articl> findByNameContains(@Param("mc") String nom, Pageable pageable);
}
