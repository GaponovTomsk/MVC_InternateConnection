package com.mvc.mvc_internateconnection.controller;


import com.mvc.mvc_internateconnection.mapper.StatementMapper;
import com.mvc.mvc_internateconnection.model.*;
import com.mvc.mvc_internateconnection.model.dto.StatementDTO;
import com.mvc.mvc_internateconnection.repository.CityRepository;
import com.mvc.mvc_internateconnection.repository.StatementRepository;
import com.mvc.mvc_internateconnection.service.city.CityService;
import com.mvc.mvc_internateconnection.service.statement.StatementService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class StatementController {


    private static final Logger log = LoggerFactory.getLogger(StatementController.class);
    private final StatementService statementService;
    private final CityService cityService;
    private final StatementMapper statementMapper;



    @GetMapping(value="/admin-panel")
    public String getAdminPanel(Model model) {
        List<Statement> all = statementService.findAll();
        model.addAttribute("statementList", all);
        return "admin_panel";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getViewFormRegistrationStatement(Model model){
        StatementDTO statement = new StatementDTO();
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


    //logic methods write in service
    // method (check city and street -> return message (type String) and html index
    // or null (else null hat save object statement in database))
    //added javadoc comments

    @RequestMapping(value = "/add_bid", method = RequestMethod.POST)
    public String addBidPost(@ModelAttribute StatementDTO statementDTO, Model model){

        String street = statementDTO.getStreet();
        String city = statementDTO.getCity();

        City city1 = cityService.findCityByName(city);
        if(city1 == null) {
            model.addAttribute("message", "City is not in base");
            log.info("message " + model.getAttribute("message"));
            return "index";
        }


        Set<Street> streetList = city1.getStreets();
        log.info(streetList.toString());
        boolean contains = false;

        //search street in set from for -> save in contains
        //boolean contains = streetList.contains(street);

        for (Street s : streetList) {
            if (s.getName().equalsIgnoreCase(street)) {
                contains = true;
                break;
            }
        }

        if(!contains) {
            model.addAttribute("message", "Street is not in base");
            return "index";
        }


        statementService.save(statementMapper.toEntity(statementDTO));
        System.out.println(statementDTO);

        model.addAttribute("fullName",statementDTO.getFullName());
        model.addAttribute("phone", statementDTO.getPhone());
        return "result";
    }
}
