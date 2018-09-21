package it.unito.ingestionservice.events;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/*
    Interfaccia che definisce i vari canali utilizzati dalla Spring Cloud Stream Application
    Nel caso specifico viene definito un solo canale di output (associato ad uno specifico Kafka Topic condiviso con
    il consumer) su cui inviare i messaggi
 */
public interface GreetingsStreams {
    String OUTPUT = "greetings-out";

    @Output(OUTPUT)
    MessageChannel outboundGreetings();
}