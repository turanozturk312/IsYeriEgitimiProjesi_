package com.isyeri.modules.user.kullanici;

import com.isyeri.modules.chat.entity.Chat;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "kullanicilar",path = "kullanicilar")
@CrossOrigin
public interface KullaniciRepository extends JpaRepository<Kullanici,Long> {

    Kullanici findByEposta(String eposta);

}
