package com.isyeri.modules.survey;

import lombok.Data;

@Data
public class SurveyQuestionDto {

    private Long id;
    private Long surveyId;
    private int questionNumber;
    private String soru;
    private String tip;
    private String secenekler;

}
