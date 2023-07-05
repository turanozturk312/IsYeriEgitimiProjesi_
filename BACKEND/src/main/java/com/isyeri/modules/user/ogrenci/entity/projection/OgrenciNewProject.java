package com.isyeri.modules.user.ogrenci.entity.projection;

import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ogrencitest", types = Ogrenci.class)
public class OgrenciNewProject {
    String ad(){return "turanaaaa";}
}
