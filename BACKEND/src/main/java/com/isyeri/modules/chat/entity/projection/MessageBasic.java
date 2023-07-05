package com.isyeri.modules.chat.entity.projection;

import com.isyeri.modules.chat.entity.Message;
import com.isyeri.modules.user.kullanici.entity.projection.KullaniciBasic;
import com.isyeri.modules.user.kullanici.entity.projection.KullaniciChat;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "messageBasic", types = { Message.class })
public interface MessageBasic {

    Long getId();
    String getContent();
    KullaniciChat getSender();

}
