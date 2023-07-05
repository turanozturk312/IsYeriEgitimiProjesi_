package com.isyeri.modules.user.ogrenci.modules.skill.repository;

import com.isyeri.modules.user.ogrenci.modules.skill.entity.Skill;
import com.isyeri.modules.user.ogrenci.modules.skill.entity.SkillLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "skill_levels",path = "skill_levels")
@CrossOrigin
public interface SkillLevelRepository extends JpaRepository<SkillLevel,Long> {

    SkillLevel findBySkill(Skill skill);
    SkillLevel findByOgrenci_IdAndAndSkill_Id(Long ogrenciId, Long skillId);
}
