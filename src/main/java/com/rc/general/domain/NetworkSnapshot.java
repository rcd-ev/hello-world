package com.rc.general.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rc.pool.domain.PoolHashrate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "network_snapshot")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
public class NetworkSnapshot {

	@Id
	@GeneratedValue(generator = "snetwork_trtl")
	@SequenceGenerator(name = "snetwork_trtl", sequenceName = "snetwork_trtl", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "hashrate", nullable = false)
	private double hashrate;

	@OneToMany(mappedBy = "network", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PoolHashrate> pools = new ArrayList<>();

	@Column(name = "created", nullable = false)
	private Timestamp created;

}
