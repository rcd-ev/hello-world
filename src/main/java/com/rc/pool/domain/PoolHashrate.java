package com.rc.pool.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rc.general.domain.NetworkSnapshot;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "pool_hashrate")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
public class PoolHashrate {

	@Id
	@GeneratedValue(generator = "spools")
	@SequenceGenerator(name = "spools", sequenceName = "spools", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "hashrate", nullable = false)
	private double hashrate;

	@Column(name = "created", nullable = false)
	private Timestamp created;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "network_id", nullable = false)
	@JsonIgnore
	private NetworkSnapshot network;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pool_data_id", nullable = false)
	@JsonIgnore
	private PoolData poolData;

}
