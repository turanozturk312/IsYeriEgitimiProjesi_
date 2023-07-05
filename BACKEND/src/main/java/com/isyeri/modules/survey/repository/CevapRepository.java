package com.isyeri.modules.survey.repository;

import com.isyeri.modules.survey.entity.Cevap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cevaplar",path = "cevaplar")
@CrossOrigin
public interface CevapRepository extends JpaRepository<Cevap,Long> {
    List<Cevap> save(List<Cevap> cevaplar);
    List<Cevap> findAllByAnket_IdAndKullanici_Id(Long anketId, Long kullaniciId);
}
