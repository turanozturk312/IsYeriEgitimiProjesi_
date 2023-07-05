package com.isyeri.modules.user.ogrenci.modules.skill.projection;

import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import com.isyeri.modules.user.ogrenci.modules.skill.entity.Skill;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "StudentSkills", types = Skill.class)
public interface StudentSkillProjection {

    String getSkillName();
    SkillLevelProjection getSkillLevel();

}
