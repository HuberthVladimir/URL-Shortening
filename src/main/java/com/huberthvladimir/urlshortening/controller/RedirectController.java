package com.huberthvladimir.urlshortening.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.huberthvladimir.urlshortening.service.RedirectService;

@RestController
public class RedirectController {

    private final RedirectService redirectService;

    public RedirectController(RedirectService redirectService) {
        this.redirectService = redirectService;
    }

    @GetMapping("{shortUrl}")
    public RedirectView RedirectUser(@PathVariable String shortUrl, RedirectAttributes attributes) {
        return redirectService.redirect(shortUrl, attributes);
    }

}
