package com.lokman.UrlShortener.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="url")
public class ShortenUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private String shortUrl;
	private String longUrl;

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
