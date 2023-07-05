package com.isyeri.modules.user.isveren;

import com.isyeri.modules.company.entity.Firma;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "isverenler")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public class Isveren extends Kullanici {

    @Column(name = "isveren_gorev")
    private String isverenGorev;

    @Column(name = "isveren_sgk_tescil")
    private String isverenSgkTescil;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "firma_id")
    private Firma isverenFirma;

}
