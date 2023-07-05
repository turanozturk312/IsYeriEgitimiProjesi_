package com.isyeri.modules.user.ogrenci.modules.skill.projection;

import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import com.isyeri.modules.user.ogrenci.modules.skill.entity.SkillLevel;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "skillLevel", types = SkillLevel.class)
public interface SkillLevelProjection {

    int getLevel();

}
