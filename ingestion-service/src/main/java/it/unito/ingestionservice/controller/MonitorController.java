package it.unito.ingestionservice.controller;

import it.unito.ingestionservice.events.model.Greeting;
import it.unito.ingestionservice.events.source.GreetingSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/orchestra")
public class MonitorController {

    private final GreetingSource greetingSource;

    @Autowired
    public MonitorController(GreetingSource greetingSource) {
        this.greetingSource = greetingSource;
    }

    @GetMapping("/test/{messaggio}")
    public  String getMessaggio(@PathVariable String messaggio) {
        log.info("Messaggio passato: {}",messaggio);
        return "Messaggio passato: "+ messaggio ;
    }

    @GetMapping("/greeting/{name}")
    public void publish(@PathVariable String name) {

        log.info("Ricevuto richiesta di invio messaggio!");
        String message = "Hello "+ name +"!";

        Greeting greeting = Greeting.builder()
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();
        greetingSource.sendGreeting(greeting);
    }

}
