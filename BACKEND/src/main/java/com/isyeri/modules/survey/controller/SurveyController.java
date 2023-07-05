package com.isyeri.modules.survey.controller;

import com.isyeri.modules.survey.SurveyQuestionDto;
import com.isyeri.modules.survey.entity.Soru;
import com.isyeri.modules.survey.repository.AnketRepository;
import com.isyeri.modules.survey.repository.SoruRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class SurveyController {

    private final AnketRepository anketRepository;
    private final SoruRepository soruRepository;

    @PostMapping("/addQuestionToSurvey")
    public ResponseEntity<?> addQuestion(@RequestBody SurveyQuestionDto surveyQuestionDto){

        Soru soru = new Soru();
        soru.setSoru(surveyQuestionDto.getSoru());
        System.out.println("QQQQQQ"+surveyQuestionDto.getQuestionNumber());
        soru.setQuestionNumber(surveyQuestionDto.getQuestionNumber());
        soru.setTip(surveyQuestionDto.getTip());
        soru.setSecenekler(surveyQuestionDto.getSecenekler());
        soru.setAnket(anketRepository.findById(surveyQuestionDto.getSurveyId()).get());
        soruRepository.save(soru);
        return ResponseEntity.ok(null);
    }

}
