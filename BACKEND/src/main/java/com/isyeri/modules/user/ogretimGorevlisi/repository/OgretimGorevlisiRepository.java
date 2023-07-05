package com.isyeri.modules.user.ogretimGorevlisi.repository;

import com.isyeri.modules.user.ogretimGorevlisi.entity.OgretimGorevlisi;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "ogretimGorevlileri",path = "ogretimGorevlileri")
@CrossOrigin
public interface OgretimGorevlisiRepository extends JpaRepository<OgretimGorevlisi,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE OgretimGorevlisi e SET e.studentGroup = null")
    void clearTeacherGroup();

}
