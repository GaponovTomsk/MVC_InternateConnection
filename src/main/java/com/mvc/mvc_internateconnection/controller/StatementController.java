package com.mvc.mvc_internateconnection.controller;


import com.mvc.mvc_internateconnection.model.Statement;
import com.mvc.mvc_internateconnection.model.TariffType;
import com.mvc.mvc_internateconnection.repository.StatementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StatementController {
    private StatementRepository statementRepository;


    public StatementController(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }

    @GetMapping(value="/admin-panel")
    public String getAdminPanel(Model model) {
        List<Statement> all = statementRepository.findAll();
        model.addAttribute("statementList", all);
        return "admin_panel";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getViewFormRegistrationStatement(){
        return "index";
    }

    @RequestMapping(value = "/add_bid", method = RequestMethod.POST)
    public String addBidPost(@RequestParam String fullName,
                             @RequestParam String city,
                             @RequestParam String street,
                             @RequestParam String house,
                             @RequestParam String tariff,
                             @RequestParam String phone
                             ){

        TariffType tariffType;
        if (tariff.equals("Basic (50Мб) 500 руб")){
            tariffType = TariffType.LIGHT;
        } else if(tariff.equals("Standard (100Мб) 700 руб")){
            tariffType = TariffType.BASIC;
        } else if(tariff.equals("Premium (300Мб) 1000 руб")) {
            tariffType = TariffType.ULTRA;
        }else {
            tariffType = TariffType.LIGHT;
        }
        Statement statement = new Statement("Moscow", "Lenina", "12", "Dima Petrov",tariffType );
        statementRepository.save(statement);
        System.out.println(statement);

        return "index";
    }
}
