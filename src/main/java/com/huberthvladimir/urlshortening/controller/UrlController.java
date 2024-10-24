package com.huberthvladimir.urlshortening.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{shortUrl}")
    public ResponseEntity<UrlModel> listOriginalUrl(@PathVariable String shortUrl) {
        return ResponseEntity.status(HttpStatus.OK).body(urlService.listUrl(shortUrl));
    }

    @PostMapping
    public ResponseEntity<UrlModel> createShortUrl(@RequestBody LinkRequestDto link) {
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.saveUrl(link));
    }

    @PutMapping("{shortUrl}")
    public ResponseEntity<UrlModel> UpdateUrl(@PathVariable String shortUrl, @RequestBody LinkRequestDto link) {
        return ResponseEntity.status(HttpStatus.OK).body(urlService.updateUrl(shortUrl, link));
    }
    
    @DeleteMapping("{shortUrl}")
    public ResponseEntity<Void> DeleteUrl(@PathVariable String shortUrl) {
        urlService.deleteShortCode(shortUrl);
        return ResponseEntity.noContent().build();
    }

}
