package com.isyeri.modules.studentGroup.entity;


import com.isyeri.modules.user.kullanici.entity.Kullanici;
import com.isyeri.modules.user.kullanici.entity.projection.KullaniciBasic;
import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import com.isyeri.modules.user.ogretimGorevlisi.entity.OgretimGorevlisi;
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
@Table(name = "ogrenci_gruplari")
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int groupNumber;
    private int kontenjan;

    @OneToMany(mappedBy = "studentGroup")
    private List<Ogrenci> ogrenciler;

    @OneToOne
    @JoinColumn(name = "ogretim_gorevlisi_id")
    private OgretimGorevlisi ogretimGorevlisi;



}
