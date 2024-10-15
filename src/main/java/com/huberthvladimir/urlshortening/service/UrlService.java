package com.huberthvladimir.urlshortening.service;

import org.springframework.stereotype.Service;

import com.huberthvladimir.urlshortening.domain.UrlModel;
import com.huberthvladimir.urlshortening.dto.LinkRequestDto;
import com.huberthvladimir.urlshortening.repositories.UrlRepository;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    private final RandomIdGenerator randomIdGenerator;

    public UrlService(UrlRepository urlRepository, RandomIdGenerator randomIdGenerator) {
        this.urlRepository = urlRepository;
        this.randomIdGenerator = randomIdGenerator;
    }

    public UrlModel listUrl(String shortUrl) {
        return urlRepository.findByShortCodeContaining(shortUrl);
    }

    public UrlModel saveUrl(LinkRequestDto linkRequestDto) {
        UrlModel url = new UrlModel();
        UrlModel urlAlreadyExist = urlRepository.findByUrlContaining(linkRequestDto.url());
        
        if(urlAlreadyExist != null) {
            return urlAlreadyExist;
        }
        url.SetUrl(linkRequestDto.url());

        String shortCode;

        do {
            shortCode = randomIdGenerator.getBase64(8);
        } while (urlRepository.existsByShortCode(shortCode));

        url.setShortCode(shortCode);

        return urlRepository.save(url);
    }
}
