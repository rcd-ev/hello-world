package com.rc.pool.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "POOL_HISTORY")
public class PoolHistory implements Serializable {

	@Id
	@GeneratedValue(generator = "S_POOL_HISTORY")
	@SequenceGenerator(name = "S_POOL_HISTORY", sequenceName = "S_POOL_HISTORY", allocationSize = 1)
	private Long id;

	@Column(name = "HASHRATE", nullable = false)
	private String hashrate;

	@Column(name = "HEIGHT", nullable = false)
	private String height;

	@Column(name = "DIFFICULTY", nullable = false)
	private String difficulty;

	@Column(name = "CREATED", nullable = false)
	private LocalDateTime created;

}
