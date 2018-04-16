package com.rc.general.domain;

import com.rc.pool.domain.PoolList;
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
@Table(name = "GLOBAL_INFO")
public class GlobalInfo implements Serializable {

	@Id
	@GeneratedValue(generator = "S_GLOBAL_INFO")
	@SequenceGenerator(name = "S_GLOBAL_INFO", sequenceName = "S_GLOBAL_INFOs", allocationSize = 1)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "POOL_LISTS_ID")
	private PoolList poolList;

	@Column(name = "CREATED", nullable = false)
	private LocalDateTime created;

}
