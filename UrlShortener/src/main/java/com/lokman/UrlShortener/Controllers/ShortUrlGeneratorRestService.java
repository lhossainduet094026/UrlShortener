package com.lokman.UrlShortener.Controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lokman.UrlShortener.Model.ShortenUrl;
import com.lokman.UrlShortener.Service.ShortenUrlService;

@RestController
@RequestMapping("/api")

public class ShortUrlGeneratorRestService {

	@Autowired
	private ShortenUrlService service;

	@PostMapping("/generateShortUrl")
	public ResponseEntity generateShortUrl(@RequestBody ShortenUrl shortenUrl) {

		String longUrl = shortenUrl.getLongUrl();
		if (isValidUrl(longUrl)) {
			shortenUrl = service.getShortUrl(shortenUrl);
			System.out.println(shortenUrl);
			return new ResponseEntity<>(shortenUrl, HttpStatus.OK);

		}

		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getLongUrl/{shortUrl}")
	public ResponseEntity getLongUrlByShortUrl(HttpServletResponse response, @PathVariable String shortUrl) {

		ShortenUrl shortenUrl = service.getLongUrl(shortUrl);
		System.out.println(shortenUrl.getLongUrl());
		if (shortenUrl != null) {

			return ResponseEntity.ok().body(shortenUrl);
		}

		return null;
	}

	public static boolean isValidUrl(String host) {
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) new URL(host).openConnection();
			connection.setRequestMethod("HEAD");
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				return false;
			}
			return true;
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {

			return false;
		} finally {
			connection.disconnect();
		}
	}
}
