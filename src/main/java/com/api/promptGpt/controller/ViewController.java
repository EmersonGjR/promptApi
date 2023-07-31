package com.api.promptGpt.controller;

import com.api.promptGpt.model.TextModel;
import com.api.promptGpt.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ViewController {
    @Autowired
    AppService appService;

    @GetMapping("/home")
    public ModelAndView getHome(Model model){
        model.addAttribute("TextModel", new TextModel());
        return new ModelAndView("home");
    }
    @GetMapping("/laudos")
    public String showLaudos(Model model) {
        List<TextModel> laudos = appService.getAllaudos();
        model.addAttribute("laudos", laudos);
        return "laudos";
    }
}
