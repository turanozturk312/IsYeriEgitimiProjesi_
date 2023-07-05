package com.isyeri.modules.user.kullanici.entity.projection;

import com.isyeri.modules.chat.entity.Chat;
import com.isyeri.modules.chat.entity.projection.ChatBasicProjection;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "kullaniciBasic", types = { Kullanici.class })
public interface KullaniciBasic {

    Long getId();
    String getAd();
    String getSoyad();
    String getEposta();

    @Value("#{target.chats.stream().collect(T(java.util.stream.Collectors).toList())}")
    List<ChatBasicProjection> getChats();




}
