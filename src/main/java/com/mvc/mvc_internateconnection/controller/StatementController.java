package com.mvc.mvc_internateconnection.controller;


import com.mvc.mvc_internateconnection.model.Statement;
import com.mvc.mvc_internateconnection.model.TariffType;
import com.mvc.mvc_internateconnection.repository.StatementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String getViewFormRegistrationStatement(Model model){
        Statement statement = new Statement();
        model.addAttribute("statement",statement);
        return "index";
    }

    @RequestMapping(value = "/add_bid", method = RequestMethod.POST)
    public String addBidPost(@ModelAttribute Statement statement,
                             Model model){

        statementRepository.save(statement);
        System.out.println(statement);

        model.addAttribute("fullName",statement.getFio());
        model.addAttribute("phone", statement.getPhone());
        return "result";
    }
}
