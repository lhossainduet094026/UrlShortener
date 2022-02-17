package com.lokman.UrlShortener.Controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lokman.UrlShortener.Model.ShortenUrl;

@RestController
@RequestMapping("/api")
public class ShortUrlGeneratorRestService {

	@PostMapping("/generateShortUrl")
	public void generateShortUrl(@ModelAttribute("shortenUrl") ShortenUrl shortenUrl) {

	}
}
