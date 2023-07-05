package com.isyeri.modules.chat.entity.projection;

import com.isyeri.modules.chat.entity.Chat;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import com.isyeri.modules.user.kullanici.entity.projection.KullaniciBasic;
import com.isyeri.modules.user.kullanici.entity.projection.KullaniciChat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;


import java.util.List;
import java.util.stream.Collectors;

@Projection(name = "chatBasic", types = { Chat.class })
public interface ChatBasicProjection {

    Long getId();

    @Value("#{target.users.stream().collect(T(java.util.stream.Collectors).toList())}")
    List<KullaniciChat> getUsers();

    @Value("#{target.messages.stream().limit(1).collect(T(java.util.stream.Collectors).toList())}")
    List<MessageContent> getMessages();

}
