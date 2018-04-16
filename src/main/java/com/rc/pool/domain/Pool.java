package com.rc.pool.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "POOL")
public class Pool implements Serializable {

	@Id
	@GeneratedValue(generator = "S_POOL")
	@SequenceGenerator(name = "S_POOL", sequenceName = "S_POOL", allocationSize = 1)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "REGION", nullable = false)
	private String region;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "POOL_LISTS_ID")
	private PoolList poolList;

	@Column(name = "CREATED", nullable = false)
	private LocalDateTime created;

}
