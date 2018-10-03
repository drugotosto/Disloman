package it.unito.oeecomputationservice.events.handler;

import it.unito.oeecomputationservice.events.GreetingStreams;
import it.unito.oeecomputationservice.events.model.Greeting;
import it.unito.oeecomputationservice.repository.GreetingMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageHandler {

    @Autowired
    private GreetingMongoRepository greetingMongoRepository;

    @StreamListener(GreetingStreams.INPUT)
    public void handleGreetings(@Payload Greeting greeting) {

        log.info("Il messaggio ricevuto e: {}", greeting);
        greetingMongoRepository.save(greeting);
        log.info("Ho eseguito il salvataggio su MongoDB");
    }
}
