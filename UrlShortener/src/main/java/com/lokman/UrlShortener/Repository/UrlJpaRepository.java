package com.lokman.UrlShortener.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.lokman.UrlShortener.Model.ShortenUrl;

@Repository
@EnableJpaRepositories
public interface UrlJpaRepository extends JpaRepository<ShortenUrl, Long> {

	public ShortenUrl findByShortUrl(String shortUrl);
}
