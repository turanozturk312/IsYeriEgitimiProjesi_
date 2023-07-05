package com.isyeri.modules.user.kullanici.entity.projection;

import com.isyeri.entity.FormBir;
import com.isyeri.modules.chat.entity.Chat;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import com.isyeri.modules.user.role.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Projection(name = "userChats", types = { Kullanici.class, Chat.class })
public interface KullaniciAll {

    Long getId();
    String getEposta();

}
