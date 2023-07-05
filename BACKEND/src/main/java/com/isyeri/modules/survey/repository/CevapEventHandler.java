package com.isyeri.modules.survey.repository;

import com.isyeri.modules.survey.entity.Cevap;
import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
@RepositoryEventHandler
public class CevapEventHandler {

    @HandleBeforeCreate
    public void handleAnswersBeforeCreate(Cevap cevapList){



    }

}
