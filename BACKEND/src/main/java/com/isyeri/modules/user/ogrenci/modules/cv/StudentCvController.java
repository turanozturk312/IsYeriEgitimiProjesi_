package com.isyeri.modules.user.ogrenci.modules.cv;

import com.isyeri.modules.user.ogrenci.OgrenciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class StudentCvController {

    private final OgrenciRepository ogrenciRepository;
    private final StudentCvRepository studentCvRepository;

    @PostMapping("/saveCv")
    @CrossOrigin
    public ResponseEntity<?> saveCv(@ModelAttribute OgrenciCvDto ogrenciCvDto) throws IOException {

        StudentCv studentCv = new StudentCv();
        studentCv.setOgrenci(ogrenciRepository.findById(ogrenciCvDto.getKullaniciId()).get());

        MultipartFile file = ogrenciCvDto.getFile();

        studentCv.setName(file.getOriginalFilename());
        studentCv.setData(file.getBytes());
        studentCv.setType(file.getContentType());

        StudentCv responseCv = studentCvRepository.save(studentCv);
        StudentCvBasic studentCvBasic = new StudentCvBasic();
        studentCvBasic.setData(responseCv.getData());
        studentCvBasic.setName(responseCv.getName());
        studentCvBasic.setType(responseCv.getType());
        studentCvBasic.setOgrenciId(responseCv.getOgrenci().getId());
        studentCvBasic.setId(responseCv.getId());

        return ResponseEntity.ok(studentCvBasic);
    }

}
