package com.isyeri.modules.user.ogrenci.modules.cv;

import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ogrenci_cv")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Lob
    private byte[] data;

    @OneToOne
    @JoinColumn(name = "ogrenci_id")
    private Ogrenci ogrenci;

}