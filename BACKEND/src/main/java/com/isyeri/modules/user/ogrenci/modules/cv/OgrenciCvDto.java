package com.isyeri.modules.user.ogrenci.modules.cv;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
public class OgrenciCvDto {

    private Long kullaniciId;
    private MultipartFile file;

}
