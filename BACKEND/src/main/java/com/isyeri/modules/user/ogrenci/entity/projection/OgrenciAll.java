package com.isyeri.modules.user.ogrenci.entity.projection;

import com.isyeri.entity.FormBir;
import com.isyeri.modules.user.kullanici.entity.projection.KullaniciAll;
import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ogrenciAll", types = { Ogrenci.class, FormBir.class })
public interface OgrenciAll extends KullaniciAll {
    Long getId();
    String getAd();
    String getSoyad();
    String getEposta();
    String getTckn();
    String getOgrenciNumarasi();
}
