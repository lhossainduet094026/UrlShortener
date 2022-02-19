package com.lokman.UrlShortener.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lokman.UrlShortener.Model.ShortenUrl;
import com.lokman.UrlShortener.Repository.UrlJpaRepository;

@Service
public class ShortenUrlService {

	@Autowired
	private UrlJpaRepository urlRepository;

	public ShortenUrl getShortUrl(ShortenUrl shortenUrl) {
		String shortUrl = generateShortUrl();
		shortenUrl.setShortUrl(shortUrl);

		urlRepository.save(shortenUrl);

		return shortenUrl;
	}

	public ShortenUrl getLongUrl(String shorUrl) {

		return urlRepository.findByShortUrl(shorUrl);

	}

	private String generateShortUrl() {

		String randomString = "";
		String possibleCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 5; i++) {
			double randomCharPosition = Math.floor(Math.random() * possibleCharacters.length());
			randomString += possibleCharacters.charAt((int) randomCharPosition);
		}
		return randomString;
	}

}
