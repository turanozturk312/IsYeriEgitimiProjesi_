package com.isyeri.controller;

import com.isyeri.modules.user.ogrenci.OgrenciRepository;
import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class DataController {

    private final OgrenciRepository ogrenciRepository;

    @PostMapping("/api/addStudentData/{count}")
    @Transactional
    public void addStudentData(@PathVariable Long count) {
        Random random = new Random();
        for (int i = 1; i <= count; i++) {
            Ogrenci ogrenci = new Ogrenci();
            ogrenci.setAd("Öğrenci" + "_" + this.convert(i));
            ogrenci.setSoyad(this.convert(i));
            ogrenci.setEposta("ogrenci_" + this.convert(i) + "@gazi.edu.tr");
            ogrenci.setAkademikBirim("Teknoloji Fakültesi");
            ogrenci.setBolum("Bilgisayar Mühendisliği");
            ogrenci.setParola("123456");
            ogrenci.setTckn(Integer.toString(1000000000 + (int) (random.nextDouble() * 999999999)));
            ogrenciRepository.save(ogrenci);
        }
    }


    private final String[] tensNames = {
            "",
            " on",
            " yirmi",
            " otuz",
            " kırk",
            " elli",
            " altmış",
            " yetmiş",
            " seksen",
            " doksan"
    };

    private final String[] numNames = {
            "",
            " bir",
            " iki",
            " üç",
            " dört",
            " beş",
            " altı",
            " yedi",
            " sekiz",
            " dokuz",
            " on",
            " onbir",
            " oniki",
            " onüç",
            " ondört",
            " onbeş",
            " onaltı",
            " onyedi",
            " onsekiz",
            " ondokuz"
    };


    private String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " hundred" + soFar;
    }


    public String convert(long number) {
        // 0 to 999 999 999 999
        if (number == 0) {
            return "zero";
        }

        String snumber = Long.toString(number);

        // pad with "0"
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        // XXXnnnnnnnnn
        int billions = Integer.parseInt(snumber.substring(0, 3));
        // nnnXXXnnnnnn
        int millions = Integer.parseInt(snumber.substring(3, 6));
        // nnnnnnXXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
        // nnnnnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(9, 12));

        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertLessThanOneThousand(billions)
                        + " billion ";
                break;
            default:
                tradBillions = convertLessThanOneThousand(billions)
                        + " billion ";
        }
        String result = tradBillions;

        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            case 1:
                tradMillions = convertLessThanOneThousand(millions)
                        + " million ";
                break;
            default:
                tradMillions = convertLessThanOneThousand(millions)
                        + " million ";
        }
        result = result + tradMillions;

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "one thousand ";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                        + " thousand ";
        }
        result = result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result = result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
}
