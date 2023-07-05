package com.isyeri.modules.company.entity.projection;

import com.isyeri.modules.company.entity.Firma;
import com.isyeri.modules.user.isveren.Isveren;
import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "full", types = { Firma.class })
public interface Full {
    public Long getId();
    public String getFirmaAdi();
    public String getFirmaAdres();
    public String getFirmaEmail();
    public String getFirmaSektor();
    public String getFirmaTelefon();
    public String getFirmaFaks();
    public String getFirmaWeb();
    public String getFirmaResim();
    public List<Isveren> getIsverenler();
    public List<Ogrenci> getOgrenciler();
}
