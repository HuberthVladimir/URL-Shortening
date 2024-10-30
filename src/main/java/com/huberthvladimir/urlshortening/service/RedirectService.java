package com.huberthvladimir.urlshortening.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.huberthvladimir.urlshortening.domain.StatsModel;
import com.huberthvladimir.urlshortening.domain.UrlModel;
import com.huberthvladimir.urlshortening.repositories.StatsRepository;
import com.huberthvladimir.urlshortening.repositories.UrlRepository;

@Service
public class RedirectService {

    UrlRepository urlRepository;
    StatsRepository statsRepository;

    public RedirectService(StatsRepository statsRepository, UrlRepository urlRepository) {
        this.statsRepository = statsRepository;
        this.urlRepository = urlRepository;
    }

    public RedirectView redirect(String shortUrl, RedirectAttributes attributes) {
        UrlModel destinationUrl = urlRepository.findByShortCode(shortUrl);

        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");

        if (destinationUrl == null) {
            return new RedirectView("/error");
        }

        Optional<StatsModel> stats = statsRepository.findById(destinationUrl.getId());
        stats.ifPresent(stat -> {
            stat.setAccessCount(stat.getAccessCount() + 1);
            statsRepository.save(stat);
        });

        return new RedirectView(destinationUrl.getUrl());
    }
}
