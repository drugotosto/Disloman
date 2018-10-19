package it.unito.ingestionservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin
public class ReadinessProbeKubernetesController {

    @GetMapping("/readiness")
    @ResponseStatus(value = HttpStatus.OK)
    public void kubernetesReadinessProbe(){
    }
}
