package com.isyeri.modules.chat.controller;

import com.isyeri.modules.chat.entity.Chat;
import com.isyeri.modules.chat.entity.Message;
import com.isyeri.modules.chat.entity.dto.MessageDto;
import com.isyeri.modules.chat.repository.ChatRepository;
import com.isyeri.modules.chat.repository.MessageRepository;
import com.isyeri.modules.user.kullanici.KullaniciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ChatGeneralController {

    private final ChatRepository chatRepository;
    private final KullaniciRepository kullaniciRepository;
    private final MessageRepository messageRepository;

    @PostMapping("/sendMessage")
    public MessageDto addMessage(@RequestBody MessageDto messageDto){

        Message message = new Message();
        message.setSender(kullaniciRepository.findById(messageDto.getSenderId()).get());
        message.setChat(chatRepository.findById(messageDto.getChatId()).get());
        message.setContent(messageDto.getContent());

        Message responseMessage = messageRepository.save(message);

        MessageDto respondeMessageDto = new MessageDto();
        respondeMessageDto.setId(responseMessage.getId());
        respondeMessageDto.setChatId(responseMessage.getChat().getId());
        respondeMessageDto.setSenderId(responseMessage.getSender().getId());
        respondeMessageDto.setContent(responseMessage.getContent());
        respondeMessageDto.setSendAt(responseMessage.getSentAt());

        return respondeMessageDto;
    }


}
