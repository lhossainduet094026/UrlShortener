package com.lokman.UrlShortener.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lokman.UrlShortener.Model.ShortenUrl;

@Controller
public class UrlShortenerHomeController {

	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("shortenUrl", new ShortenUrl());
		return "home";
	}
}
