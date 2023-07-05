package com.isyeri.modules.survey.repository;

import com.isyeri.modules.survey.entity.Anket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "anketler",path = "anketler")
@CrossOrigin
public interface AnketRepository extends JpaRepository<Anket, Long> {
}
