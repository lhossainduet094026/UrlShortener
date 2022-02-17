package com.lokman.UrlShortener.Model;

public class ShortenUrl {

	private String longUrl;
	private String shortUrl;

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	@Override
	public String toString() {
		return "ShortenUrl [longUrl=" + longUrl + ", shortUrl=" + shortUrl + "]";
	}

}
