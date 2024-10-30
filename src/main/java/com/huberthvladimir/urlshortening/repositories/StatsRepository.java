package com.huberthvladimir.urlshortening.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huberthvladimir.urlshortening.domain.StatsModel;

public interface StatsRepository extends JpaRepository<StatsModel, Integer>{

}
