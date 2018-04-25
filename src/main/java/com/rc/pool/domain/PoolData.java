package com.rc.pool.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "pool_data")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
public class PoolData {

	@Id
	@GeneratedValue(generator = "spool")
	@SequenceGenerator(name = "spool", sequenceName = "spool", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "url", nullable = false)
	private String url;

	@Column(name = "enable", nullable = false)
	private boolean enable;

	@Column(name = "created", nullable = false)
	private Timestamp created;

	@OneToMany(mappedBy = "poolData", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PoolHashrate> poolHashrates = new ArrayList<>();

}
