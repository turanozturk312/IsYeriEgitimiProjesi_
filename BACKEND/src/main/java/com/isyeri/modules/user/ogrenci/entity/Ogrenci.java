package com.isyeri.modules.user.ogrenci.entity;

import com.isyeri.modules.company.entity.Firma;
import com.isyeri.modules.studentGroup.entity.StudentGroup;
import com.isyeri.modules.user.ogrenci.modules.skill.entity.Skill;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import com.isyeri.modules.user.ogrenci.modules.cv.StudentCv;
import com.isyeri.modules.user.ogretimGorevlisi.entity.OgretimGorevlisi;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ogrenciler")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public class Ogrenci extends Kullanici {

    @Column(name = "ogrenci_numarasi")
    private String ogrenciNumarasi;

    private String tckn;

    private String gsm;

    @Column(name = "akademik_birim")
    @FieldNameConstants.Exclude
    private String akademikBirim;

    private String bolum;

    private String ikametgah;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "firma_id")
    private Firma isyeriEgitimFirma;

    @Lob
    private String formBirData;

    @OneToOne(mappedBy = "ogrenci")
    private StudentCv cv;

    @ManyToMany
    @JoinTable(
            name = "ogrenci_skill",
            joinColumns = @JoinColumn(name = "ogrenci_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    List<Skill> skills;

    @ManyToOne
    @JoinColumn(name = "ogretim_gorevlisi_id")
    private OgretimGorevlisi izleyiciOgretimGorevlisi;

    @ManyToOne
    @JoinColumn(name = "ogrenci_grup_id")
    private StudentGroup studentGroup;

    @Column(name = "application_status")
    private Boolean applicationStatus;


}
