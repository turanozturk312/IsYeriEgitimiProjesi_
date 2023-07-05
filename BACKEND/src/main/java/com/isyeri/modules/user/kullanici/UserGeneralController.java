package com.isyeri.modules.user.kullanici;

import com.isyeri.modules.user.kullanici.entity.Kullanici;
import com.isyeri.modules.user.kullanici.entity.dto.KullaniciChangePasswordDto;
import com.isyeri.modules.user.ogrenci.OgrenciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class UserGeneralController {

    private final KullaniciRepository kullaniciRepository;
    private final OgrenciRepository ogrenciRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/changePassword")
    @CrossOrigin
    public ResponseEntity<?> changePassword(@RequestBody KullaniciChangePasswordDto kullaniciChangePasswordDto){

        Kullanici kullanici = kullaniciRepository.findById(kullaniciChangePasswordDto.getId()).get();

        if(!passwordEncoder.matches(kullaniciChangePasswordDto.getOldPassword(), kullanici.getParola()))
            throw new BadCredentialsException("Mevcut Parolanız Hatalıdır");

        kullanici.setParola(passwordEncoder.encode(kullaniciChangePasswordDto.getNewPassword()));
        kullaniciRepository.save(kullanici);
        return ResponseEntity.ok(null);

    }

}
