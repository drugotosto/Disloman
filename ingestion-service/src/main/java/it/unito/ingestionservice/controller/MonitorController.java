package it.unito.ingestionservice.controller;

import it.unito.ingestionservice.events.model.Greetings;
import it.unito.ingestionservice.events.source.GreetingsSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/orchestra")
public class MonitorController {

    private final GreetingsSource greetingsSource;

    @Autowired
    public MonitorController(GreetingsSource greetingsSource) {
        this.greetingsSource = greetingsSource;
    }

    @GetMapping("/monitor")
    public  String getMonitor() {
        return "Monitor Restituito";
    }

    @GetMapping("/greeting/{name}")
    public void publish(@PathVariable String name) {

        log.info("Ricevuto richiesta di invio messaggio!");
        String message = "Hello "+ name +"!";

        Greetings greetings = Greetings.builder()
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();
        greetingsSource.sendGreeting(greetings);
    }

}
