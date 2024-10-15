package com.huberthvladimir.urlshortening.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huberthvladimir.urlshortening.domain.UrlModel;

public interface UrlRepository extends JpaRepository<UrlModel, Integer>{
    boolean existsByShortCode(String shortCode);
    UrlModel findByShortCodeContaining(String shortCode);
    UrlModel findByUrlContaining(String url);
}
