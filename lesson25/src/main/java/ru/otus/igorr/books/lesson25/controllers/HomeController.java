package ru.otus.igorr.books.lesson25.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;

@Controller
@Slf4j
public class HomeController {


    @GetMapping("/")
    public String home(Model model) {

        String username = "UserName";
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
        } catch(NullPointerException npe){
            LOG.warn("NPE");
        }


        model.addAttribute("username", username);
        model.addAttribute("today", Calendar.getInstance());
        return "home";
    }
}
