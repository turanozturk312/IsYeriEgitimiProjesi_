package com.isyeri.modules.studentGroup.repository;

import com.isyeri.modules.studentGroup.entity.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "studentGroups",path = "studentGroups")
@CrossOrigin
public interface StudentGroupRepository extends JpaRepository<StudentGroup,Long> {



}
