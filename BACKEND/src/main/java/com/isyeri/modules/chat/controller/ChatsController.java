package com.isyeri.modules.chat.controller;

import com.isyeri.modules.chat.dto.ChatDto;
import com.isyeri.modules.chat.dto.MessageDto;
import com.isyeri.modules.chat.dto.SenderDto;
import com.isyeri.modules.chat.entity.Chat;
import com.isyeri.modules.chat.entity.Message;
import com.isyeri.modules.chat.repository.ChatRepository;
import com.isyeri.modules.user.kullanici.KullaniciRepository;
import com.isyeri.modules.user.kullanici.dto.KullaniciChatDto;
import com.isyeri.modules.user.kullanici.dto.KullaniciDto;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chatss")
@RequiredArgsConstructor
@CrossOrigin
public class ChatsController {

    private final ChatRepository chatRepository;
    private final KullaniciRepository kullaniciRepository;
    private final ModelMapper modelMapper;

    @CrossOrigin
    @PostMapping
    public Chat add(@RequestBody ChatDto chatDto){
        Chat chat = new Chat();
        List<Kullanici> chatUsers = new ArrayList<>();
        chatDto.getUsers().stream().forEach(kullaniciDto -> {
            Kullanici kullanici = kullaniciRepository.findById(kullaniciDto.getId()).get();
            chatUsers.add(kullanici);
        });
        chat.setUsers(chatUsers);

        List<Message> messages = new ArrayList<>();

        chatDto.getMessages().stream().forEach(
                messageDto -> {
                    Message message = new Message();
                    Kullanici sender = kullaniciRepository.findById(messageDto.getSender().getId()).get();
                    message.setChat(chat);
                    message.setContent(messageDto.getContent());
                    message.setSentAt(message.getSentAt());
                    message.setSender(sender);
                    messages.add(message);
                }
        );

        chat.setMessages(messages);
        Chat chats = chatRepository.save(chat);
        //ChatDto dto = modelMapper.map(addedChat,ChatDto.class);
        //return ResponseEntity.ok(modelMapper.map(addedChat,ChatDto.class));
         return null;
        }

    public List<Chat> getChatsByUserId(Long id){
        return null;
    }

    @GetMapping("/user/{id}")
    public List<ChatDto> getChatByUserId(@PathVariable Long id){
        Kullanici kullanici = kullaniciRepository.findById(id).get();
        List<Chat> chats = chatRepository.findAllByUsers(kullanici);

        List<ChatDto> chatDtos = new ArrayList<>();

        chats.stream().forEach(
                chat -> {
                    ChatDto chatDto = new ChatDto();
                    List<MessageDto> messageDtos = new ArrayList<>();
                    chat.getMessages().stream().forEach(
                            message -> {
                                MessageDto messageDto = new MessageDto();
                                SenderDto senderDto = new SenderDto();
                                senderDto.setEposta(message.getSender().getEposta());
                                senderDto.setId(message.getSender().getId());
                                senderDto.setAd(message.getSender().getAd());
                                senderDto.setSoyad(message.getSender().getSoyad());
                                messageDto.setSender(senderDto);
                                messageDto.setSentAt(message.getSentAt());
                                messageDto.setContent(message.getContent());
                                messageDtos.add(messageDto);
                            }
                    );
                    List<KullaniciChatDto> kullaniciChatDtos = new ArrayList<>();
                    chat.getUsers().stream().forEach(
                            kullanici1 -> {
                                KullaniciChatDto kullaniciChatDto = new KullaniciChatDto();
                                kullaniciChatDto.setEposta(kullanici1.getEposta());
                                kullaniciChatDto.setAd(kullanici1.getAd());
                                kullaniciChatDto.setSoyad(kullanici1.getSoyad());
                                kullaniciChatDto.setId(kullanici1.getId());
                                kullaniciChatDtos.add(kullaniciChatDto);
                            }
                    );
                    chatDto.setUsers(kullaniciChatDtos);
                    chatDtos.add(chatDto);
                }
        );
        return chatDtos;
    }


}
