package com.isyeri.modules.user.kullanici.dto;

import com.isyeri.modules.chat.dto.ChatDto;
import com.isyeri.modules.chat.dto.MessageDto;
import com.isyeri.modules.user.role.Role;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class KullaniciChatDto {

    private Long id;
    private String eposta;
    private String ad;
    private String soyad;

}
