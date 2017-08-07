package com.example.helpers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ResponseEntityWine<T, E> extends RestTemplate{
	
	protected ApiService apiService;
	protected HttpMethod httpMethod;
	protected HttpEntity<T> requestEntity;
	protected Class<E> classResponse; 
	
	public ResponseEntityWine(ApiService apiService,T entityRequest, Class<E> classResponse) {
		this.apiService = apiService;
		this.classResponse = classResponse;
		httpMethod = HttpMethod.POST;
        super.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestEntity = new HttpEntity<T>(entityRequest, requestHeaders);
	}
	
	public ResponseEntity<E> doRequest() throws RestClientException, Exception{
		return this.exchange(apiService.getUrl(), httpMethod,requestEntity, classResponse);
	}

}
