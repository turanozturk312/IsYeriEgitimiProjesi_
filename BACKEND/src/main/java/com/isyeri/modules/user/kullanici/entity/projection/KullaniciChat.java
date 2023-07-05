package com.isyeri.modules.user.kullanici.entity.projection;

import com.isyeri.modules.chat.entity.Chat;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "kullaniciChat", types = { Chat.class })
public interface KullaniciChat {

    Long getId();
    String getAd();
    String getSoyad();
    String getEposta();

}
