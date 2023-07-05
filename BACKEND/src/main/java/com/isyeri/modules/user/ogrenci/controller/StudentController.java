package com.isyeri.modules.studentGroup.controller;

import com.isyeri.modules.studentGroup.StudentGroupBasicDto;
import com.isyeri.modules.studentGroup.entity.StudentGroup;
import com.isyeri.modules.studentGroup.repository.StudentGroupRepository;
import com.isyeri.modules.user.ogrenci.OgrenciRepository;
import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import com.isyeri.modules.user.ogretimGorevlisi.entity.OgretimGorevlisi;
import com.isyeri.modules.user.ogretimGorevlisi.repository.OgretimGorevlisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    private final OgrenciRepository ogrenciRepository;
    private final StudentGroupRepository studentGroupRepository;
    private final OgretimGorevlisiRepository ogretimGorevlisiRepository;

    @PostMapping("/addTeacherToStudent/student/{studentId}/teacher/{teacherId}")
    public ResponseEntity<?> addStudentToGroup(@PathVariable Long studentId,
                                               @PathVariable Long teacherId) {
        Ogrenci ogrenci = ogrenciRepository.findById(studentId).get();
        OgretimGorevlisi ogretimGorevlisi = ogretimGorevlisiRepository.findById(teacherId).get();
        ogrenci.setIzleyiciOgretimGorevlisi(ogretimGorevlisi);
        ogrenciRepository.save(ogrenci);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/removeTeacherFromStudent/{id}")
    public ResponseEntity<?> removeStudentFromGroup(@PathVariable Long id){
        Ogrenci ogrenci = ogrenciRepository.findById(id).get();
        ogrenci.setIzleyiciOgretimGorevlisi(null);
        ogrenciRepository.save(ogrenci);
        return ResponseEntity.ok(null);
    }


}
