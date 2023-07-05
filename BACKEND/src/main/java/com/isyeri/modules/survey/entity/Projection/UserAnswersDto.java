package com.isyeri.modules.survey.entity.Projection;

import com.isyeri.modules.survey.entity.Anket;
import com.isyeri.modules.survey.entity.Soru;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAnswersDto {

    private Long id;
    private Long kullaniciId;
    private Long soruId;
    private Long anketId;
    private SoruDto soruDto;
    private String cevap;

}
