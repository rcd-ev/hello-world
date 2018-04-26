package com.rc.general.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rc.pool.domain.PoolHashrate;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.NumberFormat;

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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "network_snapshot")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
public class NetworkSnapshot {

	@Id
	@GeneratedValue(generator = "s_network_snapshot")
	@SequenceGenerator(name = "s_network_snapshot", sequenceName = "s_network_snapshot", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "hashrate", nullable = false)
	@NumberFormat(pattern = "##")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "##")
	private double hashrate;

	@OneToMany(mappedBy = "network", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PoolHashrate> pools = new ArrayList<>();

	@Column(name = "created", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "Europe/Warsaw")
	private Timestamp created;

}
