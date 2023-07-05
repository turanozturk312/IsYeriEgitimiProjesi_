package com.isyeri.modules.user.ogretimGorevlisi.entity;

import com.isyeri.modules.studentGroup.entity.StudentGroup;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
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
@Table(name = "ogretim_gorevlileri")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public class OgretimGorevlisi extends Kullanici {

    @Column(name = "akademik_birim")
    @FieldNameConstants.Exclude
    private String akademikBirim;
    private String bolum;

    @OneToMany(mappedBy = "izleyiciOgretimGorevlisi")
    private List<Ogrenci> ogrenciler;

    @OneToOne(mappedBy = "ogretimGorevlisi")
    private StudentGroup studentGroup;

    private String unvan;

}
