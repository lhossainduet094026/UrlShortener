package com.lokman.UrlShortener.Repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lokman.UrlShortener.Model.ShortenUrl;

@Repository
public class UrlRepository {

	private static Map<String, ShortenUrl> urlMap = new HashMap<>();

	public void save(String uniqueKey, ShortenUrl shortUrl) {
		urlMap.put(uniqueKey, shortUrl);
	}

	public ShortenUrl getShortUrl(String shortUrl) {
		return urlMap.get(shortUrl);
	}
}
