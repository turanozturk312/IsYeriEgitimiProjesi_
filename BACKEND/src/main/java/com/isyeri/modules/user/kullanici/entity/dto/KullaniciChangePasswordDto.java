package com.isyeri.modules.user.kullanici.entity.dto;

import lombok.Data;

@Data
public class KullaniciChangePasswordDto {

    Long id;
    String oldPassword;
    String newPassword;
    String newPasswordAgain;

}
