package com.isyeri.controller;

import com.isyeri.repository.GenericQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/query")
@RequiredArgsConstructor
@CrossOrigin
public class GenericController {

    private final GenericQueryRepository genericQueryRepository;
    private final JdbcTemplate template;

    @PostMapping("/execute")
    public ResponseEntity<?> executeQuery(@RequestBody GenericQuery requestQuery){

        GenericQuery genericQuery = genericQueryRepository.findByQueryName(requestQuery.getQueryName());

        String rawQueryString = genericQuery.getQueryString();

        Map<Object,Object> parameters = (Map<Object,Object>) requestQuery.getParameters();

        for(Object key : parameters.keySet()){
            rawQueryString = rawQueryString.replace("<.."+key.toString()+"..>",parameters.get(key).toString());
        }

         List<Map<String,Object>> results = template.queryForList(rawQueryString);

        return ResponseEntity.ok(results);
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok(this.genericQueryRepository.getForm1Data());
    }

}
