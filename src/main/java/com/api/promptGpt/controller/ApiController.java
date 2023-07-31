package com.api.promptGpt.controller;

import com.api.promptGpt.dto.ResponseDto;
import com.api.promptGpt.dto.TextDto;
import com.api.promptGpt.model.TextModel;
import com.api.promptGpt.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/api")
public class ApiController {
    @Autowired
    AppService appService;
    @PostMapping("/prompt")
    public ResponseEntity<String> getChat(@RequestBody ResponseDto responseDto){
        String result = appService.textGenerator(responseDto);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/saveEdited")
    public ResponseEntity<TextModel> saveTxt(@RequestBody TextDto textDto){
        ResponseEntity<TextModel> txtsaved = appService.saveText(textDto);
        return ResponseEntity.ok(txtsaved.getBody());
    }
}
