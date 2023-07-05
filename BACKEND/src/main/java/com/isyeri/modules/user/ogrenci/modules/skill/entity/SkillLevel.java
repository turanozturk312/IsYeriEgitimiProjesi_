package com.isyeri.modules.user.ogrenci.modules.skill.entity;

import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "skill_levels")
public class SkillLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ogrenci_id")
    private Ogrenci ogrenci;

    @OneToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private int level;

}
