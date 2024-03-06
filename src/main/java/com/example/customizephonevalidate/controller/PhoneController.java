package com.example.customizephonevalidate.controller;

import com.example.customizephonevalidate.model.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/phones")
    public String show (Model model) {
        model.addAttribute("phones",new Phone());
        return "create";
    }
    @PostMapping("/phones/check")
    public String check (@Valid @ModelAttribute("phones") Phone phone, BindingResult bindingResult, Model model){
        new Phone().validate(phone,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            model.addAttribute("phones",phone);
            return "inform";
        }
    }
}
