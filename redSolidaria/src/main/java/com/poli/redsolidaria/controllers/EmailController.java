package com.poli.redsolidaria.controllers;

import com.poli.redsolidaria.models.User;
import com.poli.redsolidaria.services.EmailServiceService;
import com.poli.redsolidaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    private EmailServiceService emailServiceService;
    private final UserService userService;

    public EmailController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestParam("mail") String mail,
                            @RequestParam("subject") String subject,
                            @RequestParam("body") String body){

        body += "<br><br><b>Nombre del solicitante: </b>" + getUser().getName() + "<br><b>Correo: </b>" + getUser().getEmail() + "<br><b>Numero: </b>" + getUser().getContactNumber();
        emailServiceService.sendEmail(mail, subject, body);
        return "redirect:/donatives?success";
    }

    private User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userService.findUserByEmail(email);
    }

}
