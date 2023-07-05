package com.isyeri.modules.survey.entity.Projection;

import com.isyeri.modules.chat.entity.Chat;
import com.isyeri.modules.survey.entity.Anket;
import com.isyeri.modules.survey.entity.Soru;
import com.isyeri.modules.user.kullanici.entity.Kullanici;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "anket", types = { Anket.class })
public interface AnketProjection {

    String getAd();
    List<SoruProjection> getSorular();

}
