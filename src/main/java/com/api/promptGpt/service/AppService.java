package com.api.promptGpt.service;

import com.api.promptGpt.dto.ResponseDto;
import com.api.promptGpt.dto.TextDto;
import com.api.promptGpt.model.TextModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppService {
    ResponseEntity<TextModel> saveText(TextDto textDto);
    String textGenerator(ResponseDto responseDto);
    List<TextModel> getAllaudos();
}
