package com.isyeri.modules.user.ogrenci.entity.projection;

import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ogrenciNameSurname", types = { Ogrenci.class })
public interface OgrenciNameSurname {
    String getAd();
    String getSoyad();
}
