package com.rc.core.service.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.rc.core.service.ApiDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiDataServiceImpl implements ApiDataService {

	private String takeRequest(String uri, boolean method) {
		HttpResponse<String> body = null;

		try {
			if (method) {
				body = Unirest.get(uri).asString();
			} else {
				body = Unirest.post(uri).asString();
			}

		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return body != null ? body.getBody() : null;
	}

	@Override
	public String takeGet(String uri) {
		return takeRequest(uri, true);
	}

	@Override
	public String takePost(String uri) {
		return takeRequest(uri, false);
	}
}
