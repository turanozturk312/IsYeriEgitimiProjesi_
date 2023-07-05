package com.isyeri.modules.user.kullanici.dto;

import com.isyeri.modules.chat.dto.ChatDto;
import com.isyeri.modules.chat.dto.MessageDto;
import com.isyeri.modules.chat.entity.Chat;
import com.isyeri.modules.chat.entity.Message;
import com.isyeri.modules.user.role.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class KullaniciDto {

    private Long id;
    private String eposta;
    private List<Role> roles;
    private List<MessageDto> sentMessages;
    private Set<ChatDto> chats;

}
