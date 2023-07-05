package com.isyeri.modules.survey.repository;

import com.isyeri.modules.survey.entity.Soru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "sorular",path = "sorular")
@CrossOrigin
public interface SoruRepository extends JpaRepository<Soru,Long> {
}
