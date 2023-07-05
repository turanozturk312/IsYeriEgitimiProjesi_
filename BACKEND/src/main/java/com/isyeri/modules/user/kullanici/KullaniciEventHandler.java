package com.isyeri.modules.user.kullanici;

import com.isyeri.modules.user.kullanici.entity.Kullanici;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RepositoryEventHandler
@Component
@RequiredArgsConstructor
public class KullaniciEventHandler {

    private final PasswordEncoder passwordEncoder;

    @HandleBeforeCreate
    public void beforeCreate(Kullanici kullanici){
        kullanici.setParola(passwordEncoder.encode(kullanici.getParola()));
    }

}
