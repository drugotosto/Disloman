package it.unito.ingestionservice.controller;

import it.unito.ingestionservice.events.model.Greeting;
import it.unito.ingestionservice.events.source.GreetingSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
@CrossOrigin
//@RequestMapping(value = "orchestra")
public class MonitorController {

    private final GreetingSource greetingSource;

    @Autowired
    public MonitorController(GreetingSource greetingSource) {
        this.greetingSource = greetingSource;
    }

    @PostMapping("/greetings")
    public @ResponseBody Greeting createMessage(@RequestBody Greeting greeting) {
        log.info("Ricevuto nuovo dato da Orchestra! Aggiungo il timestamp!");
        greeting.setTimestamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
        greetingSource.sendGreeting(greeting);
        return greeting;
    }

}
