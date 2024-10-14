package com.huberthvladimir.urlshortening.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huberthvladimir.urlshortening.domain.UrlModel;
import com.huberthvladimir.urlshortening.dto.LinkRequestDto;
import com.huberthvladimir.urlshortening.service.UrlService;

@RestController
@RequestMapping("shorten")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public ResponseEntity<UrlModel> createShortUrl(@RequestBody LinkRequestDto link) {
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.saveUrl(link));
    }

}
