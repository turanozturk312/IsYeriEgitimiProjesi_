package com.isyeri.modules.chat.entity;

import com.isyeri.modules.user.kullanici.entity.Kullanici;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_id", nullable = true)
    private Chat chat;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender_id", nullable = false)
    private Kullanici sender;

    @Column(nullable = true)
    private LocalDateTime sentAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Kullanici getSender() {
        return sender;
    }

    public void setSender(Kullanici sender) {
        this.sender = sender;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        LocalDateTime time = LocalDateTime.now();
        this.sentAt = time;
    }
}
