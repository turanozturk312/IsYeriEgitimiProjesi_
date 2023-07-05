package com.isyeri.controller;

import com.isyeri.modules.survey.entity.Cevap;
import com.isyeri.modules.survey.entity.Projection.SoruDto;
import com.isyeri.modules.survey.entity.Projection.UserAnswersDto;
import com.isyeri.modules.survey.repository.AnketRepository;
import com.isyeri.modules.survey.repository.CevapRepository;
import com.isyeri.modules.survey.repository.SoruRepository;
import com.isyeri.modules.user.kullanici.KullaniciRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class GeneralControllar {

    private final CevapRepository cevapRepository;
    private final SoruRepository soruRepository;
    private final KullaniciRepository kullaniciRepository;
    private final AnketRepository anketRepository;

    @CrossOrigin
    @PostMapping("/addMultipleAnswers")
    @Transactional
    public List<UserAnswersDto> addMultipleAnswer(@RequestBody List<UserAnswersDto> answers) {
        List<Cevap> cevaplar = new ArrayList<>();
        answers.stream().forEach(
                (answer) -> {
                    if (Objects.isNull(answer.getId())) {
                        if (!Objects.isNull(answer.getCevap())) {
                            Cevap cevap = new Cevap();
                            cevap.setSoru(soruRepository.findById(answer.getSoruId()).get());
                            cevap.setKullanici(kullaniciRepository.findById(answer.getKullaniciId()).get());
                            cevap.setAnket(anketRepository.findById(answer.getAnketId()).get());
                            cevap.setCevap(answer.getCevap());
                            cevaplar.add(cevapRepository.save(cevap));
                        }
                    } else {
                        if (answer.getCevap() == null)
                            cevapRepository.deleteById(answer.getId());
                        else {
                            Cevap cevap = cevapRepository.findById(answer.getId()).get();
                            cevap.setCevap(answer.getCevap());
                            cevaplar.add(cevapRepository.save(cevap));
                        }
                    }
                }
        );
        return this.mapCevapToDto(cevaplar);
    }


    @GetMapping("/getAnswers/kullanici/{userId}/surwey/{surweyId}")
    public List<UserAnswersDto> getAnswersByUserIdAndSurweyId(@PathVariable Long userId, @PathVariable Long surweyId) {
        List<Cevap> answersDb = cevapRepository.findAllByAnket_IdAndKullanici_Id(surweyId, userId);
        return this.mapCevapToDto(answersDb);
    }

    public List<UserAnswersDto> mapCevapToDto(List<Cevap> answers) {

        List<UserAnswersDto> answerDtoList = new ArrayList<>();
        answers.stream().forEach(
                answer -> {
                    UserAnswersDto userAnswersDto = new UserAnswersDto();
                    userAnswersDto.setId(answer.getId());
                    userAnswersDto.setCevap(answer.getCevap());
                    userAnswersDto.setKullaniciId(answer.getKullanici().getId());
                    userAnswersDto.setAnketId(answer.getAnket().getId());
                    userAnswersDto.setSoruId(answer.getSoru().getId());

                    SoruDto soruDto = new SoruDto();
                    soruDto.setId(answer.getSoru().getId());
                    soruDto.setTip(answer.getSoru().getTip());
                    soruDto.setQuestionNumber(answer.getSoru().getQuestionNumber());
                    soruDto.setSecenekler(answer.getSoru().getSecenekler());
                    soruDto.setAnketId(answer.getAnket().getId());

                    userAnswersDto.setSoruDto(soruDto);

                    answerDtoList.add(userAnswersDto);
                }
        );
        return answerDtoList;
    }

}
