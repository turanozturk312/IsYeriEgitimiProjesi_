package com.isyeri.modules.chat.dto;

import com.isyeri.modules.chat.entity.Message;
import com.isyeri.modules.user.kullanici.dto.KullaniciChatDto;
import com.isyeri.modules.user.kullanici.dto.KullaniciDto;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ChatDto {

    private Long id;
    private List<KullaniciChatDto> users;
    private List<MessageDto> messages;

}
