package com.isyeri.modules.user.kullanici.entity;

import com.isyeri.modules.survey.entity.Anket;
import com.isyeri.modules.survey.entity.Cevap;
import com.isyeri.modules.user.role.Role;
import com.isyeri.modules.chat.entity.Chat;
import com.isyeri.modules.chat.entity.Message;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@Table(name = "kullanicilar")
@RequiredArgsConstructor
@AllArgsConstructor
public abstract class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;

    private String soyad;

    @Column(name = "eposta")
    private String eposta;

    @Column(name = "parola")
    private String parola;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "kullanici_role",
            joinColumns = {@JoinColumn(name = "kullanici_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private List<Message> sentMessages;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Chat> chats;

    @OneToMany(mappedBy = "kullanici")
    private List<Cevap> anketCevaplari;



}