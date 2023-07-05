package com.isyeri.modules.chat.repository;

import com.isyeri.modules.chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "messages",path = "messages")
@CrossOrigin
public interface MessageRepository extends JpaRepository<Message,Long> {

}
