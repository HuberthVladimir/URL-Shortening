package com.huberthvladimir.urlshortening.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.huberthvladimir.urlshortening.domain.UrlModel;
import com.huberthvladimir.urlshortening.repositories.UrlRepository;

@Service
public class RedirectService {

    UrlRepository urlRepository;

    public RedirectService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public RedirectView redirect(String shortUrl,  RedirectAttributes attributes) {
        UrlModel destinationUrl = urlRepository.findByShortCode(shortUrl);

        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        
        if(destinationUrl == null) {
            return new RedirectView("/error");
        }


        return new RedirectView(destinationUrl.getUrl());
    }
}
