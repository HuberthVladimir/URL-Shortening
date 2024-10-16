package com.huberthvladimir.urlshortening.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.huberthvladimir.urlshortening.domain.UrlModel;
import com.huberthvladimir.urlshortening.dto.LinkRequestDto;
import com.huberthvladimir.urlshortening.exception.InexistentUrlException;
import com.huberthvladimir.urlshortening.exception.InvalidValueException;
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
        UrlModel urlModel = urlRepository.findByShortCodeContaining(shortUrl);
        if (urlModel == null) {
            throw new InexistentUrlException(); 
        }
        return urlModel;
    }

    public UrlModel saveUrl(LinkRequestDto linkRequestDto) {
        String patterRegex = "https?:\\/\\/(www\\.)?[a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

        if (linkRequestDto.url() == null || !Pattern.matches(patterRegex, linkRequestDto.url())) {
            throw new InvalidValueException();
        }

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
