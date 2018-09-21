package it.unito.ingestionservice.events.model;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data class Greetings {
    private String message;
    private Long timestamp;
}
