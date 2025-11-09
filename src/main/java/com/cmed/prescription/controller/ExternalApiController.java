package com.cmed.prescription.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ExternalApiController {

    private final RestTemplate rest = new RestTemplate();

    @GetMapping("/api-external/interaction")
    public ResponseEntity<String> proxy() {
        String url = "https://rxnav.nlm.nih.gov/REST/interaction/interaction.json?rxcui=341248";
        String resp = rest.getForObject(url, String.class);
        return ResponseEntity.ok(resp);
    }
}
