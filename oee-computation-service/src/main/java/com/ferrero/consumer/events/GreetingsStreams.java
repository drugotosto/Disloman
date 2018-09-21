package com.ferrero.consumer.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/*
    Interfaccia che definisce i vari canali utilizzati dalla Spring Cloud Stream Application
    Nel caso specifico viene definito un solo canale di input (associato ad uno specifico Kafka Topic condiviso con
    il producer) su cui rivcevere i messaggi
 */
public interface GreetingsStreams {
    String INPUT = "greetings-in";

    @Input(INPUT)
    SubscribableChannel inboundGreetings();
}