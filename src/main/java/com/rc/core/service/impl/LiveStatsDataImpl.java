package com.rc.core.service.impl;

import com.google.gson.Gson;
import com.rc.core.domain.TrtlData;
import com.rc.core.service.ApiDataService;
import com.rc.core.service.LiveStatsData;
import com.rc.general.domain.TrtlGeneral;
import com.rc.general.domain.TrtlNetwork;
import com.rc.pool.domain.TrtlPool;
import com.rc.pool.domain.TrtlPoolRegion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LiveStatsDataImpl implements LiveStatsData {
	private final ApiDataService apiDataService;

	@Value("${configs.pools.hashrateURL}")
	private String hashrateURL;

	@Value("${configs.pools.eutsURL}")
	private String eutsURL;

	@Value("${configs.pools.atpoolURL}")
	private String atpoolURL;

	@Value("${configs.pools.mine2gURL}")
	private String mine2gURL;

	@Value("${configs.pools.tninjaURL}")
	private String tninjaURL;

	@Value("${configs.pools.zpoolURL}")
	private String zpoolURL;

	@Value("${configs.pools.hktsURL}")
	private String hktsURL;

	@Value("${configs.pools.ustsURL}")
	private String ustsURL;

	@Value("${configs.pools.nymineURL}")
	private String nymineURL;

	@Value("${configs.pools.inpoolURL}")
	private String inpoolURL;

	private String calculateHashRate(TrtlData data) {
		double difficulty = Double.parseDouble(data.getNetwork().getDifficulty());
		double coinDifficultyTarget = data.getConfig().getCoinDifficultyTarget();
		return String.valueOf((difficulty / coinDifficultyTarget));
	}

	private String hashRateToString(String hashrate){
		int i = 0;
		String[] metricUnits = {" H", " KH", " MH", " GH", " TH", " PH", " EH", " ZH"};
		double hash = Double.parseDouble(hashrate);
		while (hash > 1000) {
			hash = hash / 1000;
			i++;
		}
		DecimalFormat dec = new DecimalFormat("#0.00");
		return dec.format(hash) + metricUnits[i]+"/s";
	}

	private TrtlGeneral fillGeneralData(TrtlData data) {
		TrtlGeneral general = new TrtlGeneral();
		String hashRate = calculateHashRate(data);
		general.setDifficulty(data.getNetwork().getDifficulty());
		general.setHashrate(hashRateToString(hashRate));
		general.setHashrateRaw(hashRate);
		general.setHeight(data.getNetwork().getHeight());
		return general;
	}

	private TrtlGeneral fillGeneralData(TrtlData data, String hash) {
		TrtlGeneral general = new TrtlGeneral();
		general.setDifficulty(data.getNetwork().getDifficulty());
		general.setHashrate(hashRateToString(hash));
		general.setHashrateRaw(hash);
		general.setHeight(data.getNetwork().getHeight());
		return general;
	}

	private TrtlPool fillPoolData(TrtlData data, TrtlNetwork network, TrtlPoolRegion region) {
		TrtlPool pool = new TrtlPool();
		pool.setHashrate(hashRateToString(data.getPool().getHashrate()));
		pool.setHashrateRaw(data.getPool().getHashrate());
		pool.setName(region);
		pool.setNetwork(network);
		return pool;
	}

	private TrtlData fromJson(String json) {
		return new Gson().fromJson(json, TrtlData.class);
	}

	@Override
	public TrtlNetwork fill() {

		TrtlNetwork network = new TrtlNetwork();

		//	fetch data from endpoints
		String genHash = apiDataService.takeGet(hashrateURL);
		String euts = apiDataService.takeGet(eutsURL);
		String atpool = apiDataService.takeGet(atpoolURL);
		String mine2g = apiDataService.takeGet(mine2gURL);
		String tninja = apiDataService.takeGet(tninjaURL);
		//String zpool = apiDataService.takeGet(zpoolURL);
		String hkts = apiDataService.takeGet(hktsURL);
		String usts = apiDataService.takeGet(ustsURL);
		String nymine = apiDataService.takeGet(nymineURL);
		//String inpool = apiDataService.takeGet(inpoolURL);

		TrtlData eutsData = fromJson(euts);
		TrtlData atpoolData = fromJson(atpool);
		TrtlData mine2gData = fromJson(mine2g);
		TrtlData tninjaData = fromJson(tninja);
		//TrtlData zpoolData = fromJson(zpool);
		TrtlData hktsData = fromJson(hkts);
		TrtlData ustsData = fromJson(usts);
		TrtlData nymineData = fromJson(nymine);
		//TrtlData inpoolData = fromJson(inpool);

		TrtlGeneral general = fillGeneralData(eutsData, genHash);

		List<TrtlPool> pools = new ArrayList<>();

		TrtlPool pool1 = fillPoolData(eutsData, network, TrtlPoolRegion.EUTS);
		pools.add(pool1);
		TrtlPool pool2 = fillPoolData(atpoolData, network, TrtlPoolRegion.ATPOOL);
		pools.add(pool2);
		TrtlPool pool3 = fillPoolData(mine2gData, network, TrtlPoolRegion.MINE2G);
		pools.add(pool3);
		TrtlPool pool4 = fillPoolData(tninjaData, network, TrtlPoolRegion.TNINJA);
		pools.add(pool4);
		//TrtlPool pool5 = fillPoolData(zpoolData, network, TrtlPoolRegion.ZPOOL);
		//pools.add(pool5);
		TrtlPool pool6 = fillPoolData(hktsData, network, TrtlPoolRegion.HKTS);
		pools.add(pool6);
		TrtlPool pool7 = fillPoolData(ustsData, network, TrtlPoolRegion.USTS);
		pools.add(pool7);
		TrtlPool pool8 = fillPoolData(nymineData, network, TrtlPoolRegion.NYMINE);
		pools.add(pool8);
		//TrtlPool pool9 = fillPoolData(inpoolData, network, TrtlPoolRegion.INPOOL);
		//pools.add(pool9);

		LocalDateTime now = LocalDateTime.now();

		network.setGeneralNetwork(general);
		network.setPools(pools);
		network.setCreated(now);

		return network;
	}

}
