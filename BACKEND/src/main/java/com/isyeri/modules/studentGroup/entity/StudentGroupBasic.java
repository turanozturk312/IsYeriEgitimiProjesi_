package com.isyeri.modules.studentGroup.entity;

import com.isyeri.modules.user.kullanici.entity.Kullanici;
import com.isyeri.modules.user.kullanici.entity.projection.KullaniciBasic;
import com.isyeri.modules.user.ogrenci.entity.projection.OgrenciAll;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "StudentGroupBasic", types = { StudentGroup.class })
public interface StudentGroupBasic {
    Long getId();
    String getName();
    int getGroupNumber();
    KullaniciBasic getOgretimGorevlisi();
    List<OgrenciAll> getOgrenciler();
    int getKontenjan();
}
