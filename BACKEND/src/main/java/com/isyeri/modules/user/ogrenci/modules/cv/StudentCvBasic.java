package com.isyeri.modules.user.ogrenci.modules.cv;

import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class StudentCvBasic {


    private Long id;
    private String name;
    private String type;
    private byte[] data;
    private Long ogrenciId;

}
