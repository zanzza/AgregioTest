package com.agregio.controller;

import com.agregio.entity.Parc;
import com.agregio.service.ParcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParcController {
    @Autowired
    private ParcService service;

    @PostMapping("/parc/{name}/{type}/{megawatt}")
    public String postParc(@PathVariable String name,
                           @PathVariable String type,
                           @PathVariable int megawatt) {
        service.createParc(name, type, megawatt);
        return "Parc has been created";
    }

    @PostMapping("/parc/{name}/{type}/offre/{offreName}/{marche}")
    public String postParcToOffre(@PathVariable String name,
                                  @PathVariable String type,
                                  @PathVariable String offreName,
                                  @PathVariable String marche) {
        service.postParcToOffer(name, type, offreName, marche);
        return "Parc has been posted to the offer";
    }

    @GetMapping("/parc/{name}")
    public List<Parc> getParc(@PathVariable String name) {
        return service.getParcs(name);
    }
}
