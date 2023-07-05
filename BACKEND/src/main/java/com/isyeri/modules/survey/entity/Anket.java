package com.isyeri.modules.survey.entity;

import com.isyeri.modules.user.kullanici.entity.Kullanici;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "anketler")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Anket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;

    @OneToMany(mappedBy = "anket")
    List<Soru> sorular;

    @OneToMany(mappedBy = "anket")
    List<Cevap> cevaplar;

}
