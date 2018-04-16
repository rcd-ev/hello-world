package com.rc.general.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rc.pool.domain.TrtlPool;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trtl_network")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
public class TrtlNetwork implements Serializable {

	@Id
	@GeneratedValue(generator = "s_trtl_network")
	@SequenceGenerator(name = "s_trtl_network", sequenceName = "s_trtl_network", allocationSize = 1)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "trtl_general_id")
	private TrtlGeneral generalNetwork;

	@OneToMany(mappedBy = "network", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<TrtlPool> pools = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TrtlGeneral getGeneralNetwork() {
		return generalNetwork;
	}

	public void setGeneralNetwork(TrtlGeneral generalNetwork) {
		this.generalNetwork = generalNetwork;
	}

	public List<TrtlPool> getPools() {
		return pools;
	}

	public void setPools(List<TrtlPool> pools) {
		this.pools = pools;
	}

}
