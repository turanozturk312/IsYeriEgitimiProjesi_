package com.isyeri.modules.user.ogrenci.modules.skill.controller;

import com.isyeri.modules.user.ogrenci.modules.skill.dto.SkillDto;
import com.isyeri.modules.user.ogrenci.modules.skill.entity.Skill;
import com.isyeri.modules.user.ogrenci.modules.skill.entity.SkillLevel;
import com.isyeri.modules.user.ogrenci.modules.skill.repository.SkillLevelRepository;
import com.isyeri.modules.user.ogrenci.modules.skill.repository.SkillRepository;
import com.isyeri.modules.user.ogrenci.OgrenciRepository;
import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class SkillController {

    private final OgrenciRepository ogrenciRepository;
    private final SkillRepository skillRepository;
    private final SkillLevelRepository skillLevelRepository;

    @PostMapping("/addSkillLevel")
    @Transactional
    public ResponseEntity<?> add(@RequestBody SkillDto skillDto) {

        SkillLevel skillLevel = new SkillLevel();

        Ogrenci ogrenci = ogrenciRepository.findById(skillDto.getKullaniciId()).get();
        skillLevel.setOgrenci(ogrenci);

        if (Objects.isNull(skillRepository.findBySkillName(skillDto.getSkillName()))) {
            Skill skill = new Skill();
            skill.setSkillName(skillDto.getSkillName());
            Skill addedSkill = skillRepository.save(skill);
            List<Skill> studentSkills = ogrenci.getSkills();
            studentSkills.add(addedSkill);
            ogrenci.setSkills(studentSkills);
            ogrenciRepository.save(ogrenci);
            skillLevel.setSkill(addedSkill);
        } else {
            List<Skill> studentSkills = ogrenci.getSkills();
            studentSkills.add(skillRepository.findBySkillName(skillDto.getSkillName()));
            ogrenci.setSkills(studentSkills);
            ogrenciRepository.save(ogrenci);
            skillLevel.setSkill(skillRepository.findBySkillName(skillDto.getSkillName()));
        }

        skillLevel.setLevel(skillDto.getSkillLevel());

        skillLevelRepository.save(skillLevel);

        return ResponseEntity.ok(null);

    }

    @GetMapping("/getStudentSkills/{id}")
    public ResponseEntity<List<SkillDto>> getStudentSkillsByStudentId(@PathVariable Long id) {

        Ogrenci ogrenci = ogrenciRepository.findById(id).get();
        List<Skill> skillList = ogrenci.getSkills();
        List<SkillDto> skillDtos = new ArrayList<>();
        skillList.stream().forEach(
                skill -> {
                    SkillLevel skillLevel = skillLevelRepository.findByOgrenci_IdAndAndSkill_Id(ogrenci.getId(), skill.getId());
                    if (!Objects.isNull(skillLevel)) {
                        SkillDto skillDto = new SkillDto();
                        skillDto.setKullaniciId(ogrenci.getId());
                        skillDto.setSkillLevel(skillLevel.getLevel());
                        skillDto.setSkillName(skill.getSkillName());
                        skillDto.setId(skill.getId());
                        skillDto.setSkillLevelId(skillLevel.getId());
                        skillDtos.add(skillDto);
                    }
                }
        );
        return ResponseEntity.ok(skillDtos);
    }

    @GetMapping("/getSkillsByNameContaining")
    public ResponseEntity<List<SkillDto>> getSkillsByNameContaining(@RequestParam(name = "name") String name,
                                                                    @RequestParam(name = "size") int size,
                                                                    @RequestParam(name = "page") int page) {

        Pageable pageable = PageRequest.of(page, size);
        List<Skill> skillList = skillRepository.findBySkillNameContaining(name, pageable);
        List<SkillDto> skillDtos = new ArrayList<>();

        skillList.stream().forEach(
                skill -> {
                    SkillDto skillDto = new SkillDto();
                    skillDto.setSkillName(skill.getSkillName());
                    skillDto.setId(skill.getId());
                    skillDtos.add(skillDto);
                }
        );
        return ResponseEntity.ok(skillDtos);
    }

    @DeleteMapping("/deleteStudentSkillBySkillId/{id}")
    @Transactional
    public ResponseEntity<?> deleteStudentSkillBySkillId(@PathVariable Long id) {
        SkillLevel skillLevel = skillLevelRepository.findById(id).get();
        Skill skill = skillLevel.getSkill();
        Ogrenci ogrenci = skillLevel.getOgrenci();
        List<Skill> newSkills = new ArrayList<>();
        newSkills = ogrenci.getSkills().stream().filter(
                sk -> sk.getId() != skill.getId()
        ).collect(Collectors.toList());
        ogrenci.setSkills(newSkills);
        ogrenciRepository.save(ogrenci);
        skillLevelRepository.delete(skillLevel);
        return ResponseEntity.ok(null);
    }

}
