package ru.otus.igorr.books.lesson18.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(Model model) {


        Session session = new Session();
        session.setUser(new User("UserName"));

        model.addAttribute("msession", session);
        model.addAttribute("today", Calendar.getInstance());
        return "home";
    }
}
