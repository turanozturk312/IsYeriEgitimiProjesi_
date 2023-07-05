package com.isyeri.modules.chat.entity.dto;

import com.isyeri.modules.chat.entity.Chat;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {

    private Long id;
    private Long senderId;
    private Long chatId;
    private String content;
    private LocalDateTime sendAt;

}
