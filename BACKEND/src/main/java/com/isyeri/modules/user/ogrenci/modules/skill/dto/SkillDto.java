package com.isyeri.modules.user.ogrenci.modules.skill.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SkillDto {

    private Long id;
    private Long skillLevelId;
    private Long kullaniciId;
    private String skillName;
    private int skillLevel;

}
