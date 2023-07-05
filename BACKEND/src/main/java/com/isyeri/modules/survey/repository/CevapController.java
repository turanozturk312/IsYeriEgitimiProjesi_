package com.isyeri.modules.survey.repository;

import com.isyeri.modules.survey.entity.Cevap;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RepositoryRestController
@RequiredArgsConstructor
public class CevapController {

    private final CevapRepository cevapRepository;

    @PostMapping("/api/cevaplar")
    public List<Cevap> add(@RequestBody List<Cevap> cevaplar){
        return cevapRepository.save(cevaplar);
    }

}
