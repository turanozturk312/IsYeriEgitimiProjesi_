package com.isyeri.modules.company.entity;

import com.isyeri.modules.user.isveren.Isveren;
import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "firmalar")
public class Firma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firma_adi")
    private String firmaAdi;

    @Column(name = "firma_adres")
    private String firmaAdres;

    @Column(name = "firma_email")
    private String firmaEmail;

    @Column(name = "firma_sektor")
    private String firmaSektor;

    @Column(name = "firma_telefon")
    private String firmaTelefon;

    @Column(name = "firma_faks")
    private String firmaFaks;

    @Column(name = "firma_web")
    private String firmaWeb;

    @Column(name = "firma_resim")
    @Lob
    private String firmaResim;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "firma_id")
    private List<Isveren> isverenler;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "firma_id")
    private List<Ogrenci> ogrenciler;

}
