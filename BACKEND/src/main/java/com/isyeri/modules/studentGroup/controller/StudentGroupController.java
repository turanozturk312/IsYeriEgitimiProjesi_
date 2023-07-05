package com.isyeri.modules.studentGroup.controller;

import com.isyeri.modules.studentGroup.StudentGroupBasicDto;
import com.isyeri.modules.studentGroup.entity.StudentGroup;
import com.isyeri.modules.studentGroup.repository.StudentGroupRepository;
import com.isyeri.modules.user.ogrenci.OgrenciRepository;
import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import com.isyeri.modules.user.ogretimGorevlisi.entity.OgretimGorevlisi;
import com.isyeri.modules.user.ogretimGorevlisi.repository.OgretimGorevlisiRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class StudentGroupController {

    private final OgrenciRepository ogrenciRepository;
    private final StudentGroupRepository studentGroupRepository;
    private final OgretimGorevlisiRepository ogretimGorevlisiRepository;

    @PostMapping("/addStudentToGroup")
    public ResponseEntity<?> addStudentToGroup(@RequestBody StudentGroupBasicDto studentGroupBasicDto) {
        Ogrenci ogrenci = ogrenciRepository.findById(studentGroupBasicDto.getOgrenciId()).get();
        StudentGroup studentGroup = studentGroupRepository.findById(studentGroupBasicDto.getStudentGroupId()).get();
        ogrenci.setStudentGroup(studentGroup);
        ogrenciRepository.save(ogrenci);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/createStudentGroupAutomaticly")
    @Transactional
    public ResponseEntity<?> createGroupAutomaticly(@RequestBody JSONObject data) {

        ogrenciRepository.clearStudentsGroups();
        studentGroupRepository.deleteAll();


        List<Ogrenci> ogrenciList = ogrenciRepository.findAll().stream().filter(
                ogrenci -> {
                    if (ogrenci.getApplicationStatus() == true)
                        return true;
                    return false;
                }
        ).collect(Collectors.toList());

        int minStudent = (int) data.get("minStudent");
        int remainOpType = (int) data.get("remainOpType");
        Boolean distributeStudent = (boolean) data.get("distributeStudent");

        System.out.println("SSSSS" + remainOpType);

        int groupCount = ogrenciList.size() % minStudent == 0 ? (ogrenciList.size() / minStudent) :
                (ogrenciList.size() / minStudent) + 1;
        int remainStudent = ogrenciList.size();

        int grupAdet = ogrenciList.size() / minStudent;
        int remain = ogrenciList.size() % minStudent;

        if (remainOpType == 1) {
            for (int i = 0; i < grupAdet; i++) {
                StudentGroup studentGroup = new StudentGroup();
                studentGroup.setGroupNumber(i + 1);
                studentGroup.setName("Grup " + studentGroup.getGroupNumber());
                if (remain > 0) {
                    studentGroup.setKontenjan(minStudent + 1);
                    remain--;
                } else {
                    studentGroup.setKontenjan(minStudent);
                }
                studentGroupRepository.save(studentGroup);
            }

        } else {
            int i = 0;
            while (remainStudent > 0) {
                StudentGroup studentGroup = new StudentGroup();
                studentGroup.setGroupNumber(i + 1);
                studentGroup.setName("Grup " + studentGroup.getGroupNumber());
                if (remainStudent >= minStudent) {
                    studentGroup.setKontenjan(minStudent);
                    remainStudent = remainStudent - minStudent;
                } else {
                    studentGroup.setKontenjan(remainStudent);
                    remainStudent = 0;
                }

                studentGroupRepository.save(studentGroup);
                i++;
            }
        }


        if (distributeStudent)
            this.addStudentsToGroupsAutomaticly(minStudent);

        return null;
    }

    @DeleteMapping("/removeStudentFromGroup/{id}")
    public ResponseEntity<?> removeStudentFromGroup(@PathVariable Long id) {
        Ogrenci ogrenci = ogrenciRepository.findById(id).get();
        ogrenci.setStudentGroup(null);
        ogrenciRepository.save(ogrenci);
        return ResponseEntity.ok(null);
    }

    @Transactional
    public void addStudentsToGroupsAutomaticly(int minValue) {

        List<StudentGroup> studentGroups = studentGroupRepository.findAll();

        studentGroups.stream().forEach(
                studentGroup -> {

                    int remain = calculateRemainStudents();

                    int count = remain >= minValue ? minValue : remain;

                    List<Ogrenci> ogrenciList = ogrenciRepository.findByApplicationStatusAndStudentGroup(true, null, PageRequest.of(0, count));
                    ogrenciList.stream().forEach(

                            ogrenci -> {

                                ogrenci.setStudentGroup(studentGroup);

                                ogrenciRepository.save(ogrenci);
                            }
                    );

                }
        );
    }
    public int calculateRemainStudents() {
        return ogrenciRepository.findByApplicationStatusAndStudentGroup(true, null,null).size();
    }

    @PostMapping("/addTeacherToGroup")
    @Transactional
    public ResponseEntity<?> addTeacherToGroup(@RequestBody JSONObject data){
        Long groupId = Long.parseLong(data.get("groupId").toString());
        Long teacherId = Long.parseLong(data.get("teacherId").toString());


        StudentGroup studentGroup = studentGroupRepository.findById(groupId).get();
        List<Ogrenci> ogrenciList = ogrenciRepository.findByStudentGroup(studentGroup);
        OgretimGorevlisi ogretimGorevlisi = ogretimGorevlisiRepository.findById(teacherId).get();

        ogrenciList.stream().forEach(
                ogrenci -> {
                    ogrenci.setIzleyiciOgretimGorevlisi(ogretimGorevlisi);
                    ogrenciRepository.save(ogrenci);
                }
        );

        studentGroup.setOgretimGorevlisi(ogretimGorevlisi);
        studentGroupRepository.save(studentGroup);

        return ResponseEntity.ok(null);
    }


}
