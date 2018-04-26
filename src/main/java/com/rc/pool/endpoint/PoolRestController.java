package com.rc.pool.endpoint;

import com.rc.general.domain.NetworkSnapshot;
import com.rc.general.service.NetworkSnapshotService;
import com.rc.pool.domain.PoolData;
import com.rc.pool.domain.PoolHashrate;
import com.rc.pool.dto.PoolDto;
import com.rc.pool.service.PoolDataService;
import com.rc.pool.service.PoolMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/pool")
@RequiredArgsConstructor
public class PoolRestController {

	private final NetworkSnapshotService networkSnapshotService;
	private final PoolDataService poolDataService;
	private final PoolMapper poolMapper;

	@Value("${configs.timezone.zone}")
	private String zone;

	/*
	{
  	"name": "turtle-eu.atpool.party",
 		"url": "http://turtle-eu.atpool.party:8117/stats",
  	"enable": true
	}
	 */

	@PostMapping("/new")
	public PoolData createPoolData(@RequestBody PoolData poolData) {
		poolData.setCreated(new Timestamp(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(zone)).toInstant().toEpochMilli()));
		return poolDataService.createPoolData(poolData);
	}

	@GetMapping("{id}")
	public PoolData getPoolData(@PathVariable Long id) {
		return poolDataService.getById(id);
	}

	@PutMapping("{id}")
	public PoolData updatePoolData(@RequestBody PoolData poolData, @PathVariable Long id) {
		return poolDataService.updatePoolData(poolData, id);
	}

	@PutMapping("/activate/{id}")
	public PoolData activePoolData(@RequestBody PoolData poolData, @PathVariable Long id) {
		return poolDataService.activePoolData(poolData, id);
	}

	@GetMapping("/list")
	public @ResponseBody List<PoolData> getAllPoolData() {
		return poolDataService.findAllPoolData();
	}

	@GetMapping("/active")
	public @ResponseBody List<PoolData> getAllActivePoolData() {
		return poolDataService.listActivePool();
	}

	@GetMapping("/info")
	public List<PoolDto> findPoolByNetworkId(@RequestParam("id") long id) {
		NetworkSnapshot networks = networkSnapshotService.getNetworkById(id);
		List<PoolHashrate> entity = networks.getPools();
		return poolMapper.mapDto(entity);
	}

}
