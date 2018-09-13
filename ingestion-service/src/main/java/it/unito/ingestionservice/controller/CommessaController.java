package it.unito.ingestionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orchestra/commesse")
public class CommessaController {

    /*
    @Autowired
    private CommessaService commessaService;


    @GetMapping()
    public Commesse getCommesse() {
        return commessaService.getCommesse();
    }*/

    @GetMapping()
    public  String getCommesse() {
        return "Commesse restituite";
    }
}
