package com.isyeri.modules.chat.dto;

import com.isyeri.modules.chat.entity.Chat;
import com.isyeri.modules.user.kullanici.dto.KullaniciDto;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {

    private Long id;
    private ChatMessageDto chat;
    private String content;
    private SenderDto sender;
    private LocalDateTime sentAt = LocalDateTime.now();

}
