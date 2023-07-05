package com.isyeri.modules.user.ogrenci.modules.cv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "studentCvs",path = "studentCvs")
@CrossOrigin
public interface StudentCvRepository extends JpaRepository<StudentCv,Long> {

}
