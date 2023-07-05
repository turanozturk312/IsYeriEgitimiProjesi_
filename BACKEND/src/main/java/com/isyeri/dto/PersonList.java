package com.isyeri.dto;

import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "person-list", types = Ogrenci.class)
public interface PersonList {
    Long getId();
    String getAd();
    String getSoyad();
    String getEmail();
}
