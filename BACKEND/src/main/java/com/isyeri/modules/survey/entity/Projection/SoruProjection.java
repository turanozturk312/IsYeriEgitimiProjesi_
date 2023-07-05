package com.isyeri.modules.survey.entity.Projection;

import com.isyeri.modules.survey.entity.Soru;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "soru", types = {Soru.class})
public interface SoruProjection {
    Long getId();
    Long getQuestionNumber();
    String getSoru();
    String getTip();
    String getSecenekler();
}
