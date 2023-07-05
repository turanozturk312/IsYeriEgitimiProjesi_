package com.isyeri.modules.user.ogrenci;

import com.isyeri.modules.studentGroup.entity.StudentGroup;
import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "ogrenciler",path = "ogrenciler")
@CrossOrigin
public interface OgrenciRepository extends JpaRepository<Ogrenci,Long> {

    Ogrenci save(Ogrenci ogrenci);
    Ogrenci findOgrenciByEposta(String eposta);

    @Modifying
    @Transactional
    @Query("UPDATE Ogrenci e SET e.studentGroup = null, e.izleyiciOgretimGorevlisi = null WHERE e.applicationStatus = true ")
    void clearStudentsGroups();

    List<Ogrenci> findByApplicationStatusAndStudentGroup(Boolean status, StudentGroup studentGroup, Pageable pageRequest);
    List<Ogrenci> findByStudentGroup(StudentGroup studentGroup);

}
