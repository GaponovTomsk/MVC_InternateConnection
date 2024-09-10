package com.mvc.mvc_internateconnection.controller;


import com.mvc.mvc_internateconnection.model.*;
import com.mvc.mvc_internateconnection.repository.CityRepository;
import com.mvc.mvc_internateconnection.repository.StatementRepository;
import com.mvc.mvc_internateconnection.service.city.CityService;
import com.mvc.mvc_internateconnection.service.statement.StatementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class StatementController {


    private StatementService statementService;
    private CityService cityService;

    public StatementController(StatementService statementService, CityService cityService) {
        this.statementService = statementService;
        this.cityService = cityService;
    }

    @GetMapping(value="/admin-panel")
    public String getAdminPanel(Model model) {
        List<Statement> all = statementService.findAll();
        model.addAttribute("statementList", all);
        return "admin_panel";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getViewFormRegistrationStatement(Model model){
        Statement statement = new Statement();
        model.addAttribute("statement",statement);
        return "index";
    }

    @RequestMapping(value = "/entrance", method = RequestMethod.GET)
    public String showLoginForm(Model model) {
        model.addAttribute("admin", new Admin());  // Передача пустого объекта Admin
        return "entrance";  // Название шаблона Thymeleaf (entrance.html)
    }

    @RequestMapping(value = "/entrance", method = RequestMethod.POST)
    public String getViewFormAdmin( @ModelAttribute Admin admin, Model model){
        model.addAttribute("admin", admin);
        System.out.println(admin.getLogin() + " " + admin.getPassword());
        return "entrance";
    }

    @RequestMapping(value = "/add_bid", method = RequestMethod.POST)
    public String addBidPost(@ModelAttribute Statement statement,
                             Model model){

        String street = statement.getStreet();
        String city = statement.getCity();

        City city1 = cityService.findCityByName(city);
        if(city1 == null) {
            model.addAttribute("massage", "City is not in base");
            return "index";
        }

        Set<Street> streetList = city1.getStreets();
        boolean contains = streetList.contains(street);
        if(!contains) {
            model.addAttribute("message", "Street is notin base");
            return "index";
        }

        statementService.save(statement);
        System.out.println(statement);

        model.addAttribute("fullName",statement.getFullName());
        model.addAttribute("phone", statement.getPhone());
        return "result";
    }
}
