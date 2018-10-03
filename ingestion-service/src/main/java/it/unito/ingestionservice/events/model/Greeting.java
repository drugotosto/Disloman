package it.unito.ingestionservice.events.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Greeting {
    private String message;
    private Long timestamp;
}
