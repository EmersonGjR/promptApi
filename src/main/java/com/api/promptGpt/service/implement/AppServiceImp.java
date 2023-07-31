package com.api.promptGpt.service.implement;

import com.api.promptGpt.dto.ResponseDto;
import com.api.promptGpt.dto.TextDto;
import com.api.promptGpt.model.TextModel;
import com.api.promptGpt.repositories.TextRepository;
import com.api.promptGpt.service.AppService;
import com.api.promptGpt.service.EnvApp;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImp implements AppService {
    @Autowired
    EnvApp envApp;
   @Autowired
    TextRepository textRepository;
    @Override
    public ResponseEntity<TextModel> saveText(TextDto textDto){
        TextModel txt = new TextModel();
        txt.setText(textDto.getText());
        txt.setId(textDto.getId());
        return ResponseEntity.status(HttpStatus.OK).body(textRepository.save(txt));
    }
    @Override
    public String textGenerator(ResponseDto responseDto){
        String text = "Você é um fisioterapeuta especialista em baropometria e precisa escrever um laudo do exame estático de baropodometria de um paciente com as seguintes informações que foram coletas pelo seu sistema de baropodometria"
                + responseDto;
        OpenAiService openAiService = new OpenAiService(envApp.getKey());
        CompletionRequest request = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(text)
                .maxTokens(2000)
                .build();
        return openAiService.createCompletion(request).getChoices().get(0).getText();
    }
    @Override
    public List<TextModel> getAllaudos(){
        List<TextModel> laudos = textRepository.findAll(Sort.by("id"));
        return laudos;
    }
}
