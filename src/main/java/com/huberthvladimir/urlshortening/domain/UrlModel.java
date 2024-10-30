package com.huberthvladimir.urlshortening.domain;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "URL_TABLE")
@EntityListeners(AuditingEntityListener.class)
public class UrlModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String shortCode;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate 
    private Instant updatedAt;

    @OneToOne(mappedBy = "url", cascade = CascadeType.ALL)
    @JsonIgnore
    private StatsModel stats;

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void SetUrl(String url) {
        this.url = url;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updateAt) {
        this.updatedAt = updateAt;
    }

    public StatsModel getStats() {
        return stats;
    }

    public void setStats(StatsModel stats) {
        this.stats = stats;
    }
}
