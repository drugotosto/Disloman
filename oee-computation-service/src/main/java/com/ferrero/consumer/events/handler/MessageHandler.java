package com.ferrero.consumer.events.handler;

import com.ferrero.consumer.events.GreetingsStreams;
import com.ferrero.consumer.events.model.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageHandler {

    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {
        log.info("Il messaggio ricevuto e: {}", greetings);
    }
}
