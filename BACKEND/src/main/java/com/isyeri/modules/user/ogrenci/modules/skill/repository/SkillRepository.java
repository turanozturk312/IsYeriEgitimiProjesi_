package com.isyeri.modules.user.ogrenci.modules.skill.repository;

import com.isyeri.modules.user.ogrenci.modules.skill.entity.Skill;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "skills",path = "skills")
@CrossOrigin
public interface SkillRepository extends JpaRepository<Skill,Long> {

    Skill findBySkillName(String name);

    List<Skill> findBySkillNameContaining(String name, Pageable pageable);

}
