package com.isyeri.controller;

import com.isyeri.modules.user.kullanici.KullaniciRepository;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
public class LoginController {

    private final KullaniciRepository kullaniciRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @PostMapping("/login")
    @CrossOrigin
    public UserDetailDto login(@RequestBody LoginDto loginDto){
        Kullanici kullanici = kullaniciRepository.findByEposta(loginDto.getEposta());
        if(ObjectUtils.isEmpty(kullanici)){
            throw new UsernameNotFoundException("Bu eposta adresi ile kullanıcı bulunmamaktadır");
        }else{
            if( passwordEncoder.matches(loginDto.getParola(), kullanici.getParola()) ){
                return modelMapper.map(kullanici, UserDetailDto.class);
            }else {
                throw new BadCredentialsException("Hatalı eposta veya parola");
            }
        }
    }

}
