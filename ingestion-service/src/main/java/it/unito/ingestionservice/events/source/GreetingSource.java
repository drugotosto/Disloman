package it.unito.ingestionservice.events.source;

import it.unito.ingestionservice.events.GreetingStreams;
import it.unito.ingestionservice.events.model.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@Slf4j
@Component
public class GreetingSource {

    private final GreetingStreams greetingStreams;

    @Autowired
    public GreetingSource(GreetingStreams greetingStreams) {
        this.greetingStreams = greetingStreams;
    }

    public void sendGreeting(Greeting greeting) {
        log.info("Invio del Messaggio: {} ", greeting);
        MessageChannel messageChannel = greetingStreams.outboundGreetings();
        messageChannel.send(MessageBuilder.withPayload(greeting)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }

}
