package com.example.SpringApplication.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.SpringApplication.pojo.Pojo;

@Service
public class Serviceclass {
	
	@Value("${api.key}")
	
	String apikey;
	public Pojo fetchPojoDetails() {
		return new Pojo("sam",12,31);
	}
	
	
	public String fetchWeatherData(String city) {
		
		String url =UriComponentsBuilder.fromUriString("https://api.openweathermap.org/data/2.5/weather")
				.queryParam("q", city)
				.queryParam("appid", apikey)
				.build()
				.toUriString();
		
		RestTemplate rest = new RestTemplate();
		
		return rest.getForObject(url, String.class);
		
	}

}
