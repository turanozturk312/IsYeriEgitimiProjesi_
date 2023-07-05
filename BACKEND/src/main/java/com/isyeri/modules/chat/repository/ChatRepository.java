package com.isyeri.modules.chat.repository;

import com.isyeri.modules.chat.entity.Chat;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "chats",path = "chats")
@CrossOrigin
public interface ChatRepository extends JpaRepository<Chat,Long> {

    List<Chat> findAllByUsers(Kullanici kullanici);

}
