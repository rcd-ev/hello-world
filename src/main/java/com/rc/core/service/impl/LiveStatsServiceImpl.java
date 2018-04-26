package com.rc.core.service.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.rc.core.service.LiveStatsService;
import com.rc.general.domain.NetworkSnapshot;
import com.rc.general.service.NetworkSnapshotService;
import com.rc.pool.domain.PoolData;
import com.rc.pool.domain.PoolHashrate;
import com.rc.pool.service.PoolDataService;
import com.rc.pool.service.PoolHashrateService;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.net.ssl.SSLContext;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LiveStatsServiceImpl implements LiveStatsService {

	private final NetworkSnapshotService networkSnapshotService;
	private final PoolDataService poolDataService;
	private final PoolHashrateService poolHashrateService;

	@Value("${configs.pools.hashrateURL}")
	private String hashrateURL;

	@Value("${configs.timezone.zone}")
	private String zone;

	@Override
	public void saveData() {
		dataProcessing();
	}

	@Override
	public void dataProcessing() {
		List<PoolData> active = poolDataService.listActivePool();

		NetworkSnapshot snapshot = new NetworkSnapshot();
		List<PoolHashrate> poolHashrates = new ArrayList<>();

		for (int i=0; i<active.size()+1;i++)
			callPool(active.get(i), poolHashrates, snapshot);

		snapshot.setPools(poolHashrates);
		callNetwork(snapshot);

		networkSnapshotService.create(snapshot);
	}

	@Override
	public void callPool(PoolData active, List<PoolHashrate> poolHashrates, NetworkSnapshot snapshot) {
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
		CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom().setSSLContext(sslcontext)
				.build();
		Unirest.setAsyncHttpClient(httpclient);

		Future<HttpResponse<JsonNode>> future = Unirest.get(active.getUrl())
				.header("accept", "application/json")
				.asJsonAsync(new Callback<JsonNode>() {

					public void failed(UnirestException e) {
						e.printStackTrace();
					}

					public void completed(HttpResponse<JsonNode> response) {
						JsonNode body = response.getBody();
						PoolHashrate pool = new PoolHashrate();
						pool.setPoolData(active);
						pool.setCreated(new Timestamp(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(zone)).toInstant().toEpochMilli()));
						pool.setHashrate(body.getObject().getJSONObject("pool").getDouble("hashrate"));
						pool.setNetwork(snapshot);
						poolHashrates.add(pool);

					}

					public void cancelled() {

					}

				});
	}

	@Override
	public void callNetwork(NetworkSnapshot snapshot) {
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
		CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom().setSSLContext(sslcontext)
				.build();
		Unirest.setAsyncHttpClient(httpclient);

		Future<HttpResponse<JsonNode>> future = Unirest.get(hashrateURL)
				.header("accept", "application/json")
				.asJsonAsync(new Callback<JsonNode>() {

					public void failed(UnirestException e) {
						e.printStackTrace();
					}

					public void completed(HttpResponse<JsonNode> response) {
						JsonNode body = response.getBody();
						snapshot.setCreated(new Timestamp(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(zone)).toInstant().toEpochMilli()));
						snapshot.setHashrate(Double.parseDouble(body.toString()));
					}

					public void cancelled() {

					}

				});
	}

}
