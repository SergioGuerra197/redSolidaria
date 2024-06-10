package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.services.EmailServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    private EmailServiceService emailServiceService;

    @PostMapping("/send/{mail}/{subject}/{body}")
    public String sendEmail(@PathVariable String mail,@PathVariable String subject, @PathVariable String body){
        emailServiceService.sendEmail(mail,subject,body);
        return "Succesfull sent Mail";
    }

}
