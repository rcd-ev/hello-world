package com.rc.pool.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "POOL_INFO")
public class PoolList implements Serializable {

	@Id
	@GeneratedValue(generator = "S_POOL_INFO")
	@SequenceGenerator(name = "S_POOL_INFO", sequenceName = "S_POOL_INFO", allocationSize = 1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POOL_ID", nullable = false)
	private Pool pool;

	@Column(name = "CREATED", nullable = false)
	private LocalDateTime created;

}
