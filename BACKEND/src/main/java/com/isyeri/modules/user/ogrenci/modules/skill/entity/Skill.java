package com.isyeri.modules.user.ogrenci.modules.skill.entity;

import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skill_name")
    private String skillName;

    @OneToOne(mappedBy = "skill")
    private SkillLevel skillLevel;

    @ManyToMany(mappedBy = "skills")
    private List<Ogrenci> ogrenciList;


}
