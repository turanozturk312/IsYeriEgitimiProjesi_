package com.isyeri.modules.company.repository;

import com.isyeri.modules.company.entity.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "firmalar",path = "firmalar")
@CrossOrigin
public interface FirmaRepository extends JpaRepository<Firma,Long> {

    Firma save(Firma firma);
    Firma findFirmaByFirmaAdi(String firmaAdi);
}
