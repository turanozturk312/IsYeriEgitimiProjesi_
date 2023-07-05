package com.isyeri.modules.survey.entity.Projection;

import com.isyeri.modules.survey.entity.Anket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoruDto {

    private Long id;
    private int questionNumber;
    private String soru;
    private String tip;
    private Long anketId;
    private String secenekler;

}
