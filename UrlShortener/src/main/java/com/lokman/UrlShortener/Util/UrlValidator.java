package com.lokman.UrlShortener.Util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlValidator {
	
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
		} catch (Exception ex) {
			return false;
		}
	}
}
