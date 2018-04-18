package com.rc.core.service.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.rc.core.service.ApiDataService;
import lombok.RequiredArgsConstructor;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

@Service
@RequiredArgsConstructor
public class ApiDataServiceImpl implements ApiDataService {

	private String takeRequest(String uri, boolean method) {
		SSLContext sslcontext = null;
		try {
			sslcontext = SSLContexts.custom()
					.loadTrustMaterial(null, new TrustSelfSignedStrategy())
					.build();
		} catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
			e.printStackTrace();
		}

		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,
				SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		CloseableHttpClient httpclient = HttpClients.custom()
				.setSSLSocketFactory(sslsf)
				.build();
		Unirest.setHttpClient(httpclient);
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
