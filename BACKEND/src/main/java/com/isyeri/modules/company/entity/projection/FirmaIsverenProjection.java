package com.isyeri.modules.company.entity.projection;

import com.isyeri.modules.company.entity.Firma;
import com.isyeri.modules.user.isveren.Isveren;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "firmaIsveren", types = { Firma.class })
public interface FirmaIsverenProjection {
    List<Isveren> getIsverenler();
}
