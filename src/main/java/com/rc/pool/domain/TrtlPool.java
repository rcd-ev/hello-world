package com.rc.pool.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rc.general.domain.TrtlNetwork;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trtl_pool")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
public class TrtlPool implements Serializable {

	@Id
	@GeneratedValue(generator = "s_trtl_pool")
	@SequenceGenerator(name = "s_trtl_pool", sequenceName = "s_trtl_pool", allocationSize = 1)
	private Long id;

	@Column(name = "hashrate_raw")
	private String hashrateRaw;

	@Column(name = "hashrate")
	private String hashrate;

	@Column(name = "name", nullable = false)
	@Enumerated(EnumType.STRING)
	private TrtlPoolRegion name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trtl_network_id", nullable = false)
	@JsonIgnore
	private TrtlNetwork network;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHashrateRaw() {
		return hashrateRaw;
	}

	public void setHashrateRaw(String hashrateRaw) {
		this.hashrateRaw = hashrateRaw;
	}

	public String getHashrate() {
		return hashrate;
	}

	public void setHashrate(String hashrate) {
		this.hashrate = hashrate;
	}

	public TrtlPoolRegion getName() {
		return name;
	}

	public void setName(TrtlPoolRegion name) {
		this.name = name;
	}

	public TrtlNetwork getNetwork() {
		return network;
	}

	public void setNetwork(TrtlNetwork network) {
		this.network = network;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;

		TrtlPool trtlPool = (TrtlPool) o;

		if (id != null ? !id.equals(trtlPool.id) : trtlPool.id != null)
			return false;
		if (hashrateRaw != null ? !hashrateRaw.equals(trtlPool.hashrateRaw) : trtlPool.hashrateRaw != null)
			return false;
		if (hashrate != null ? !hashrate.equals(trtlPool.hashrate) : trtlPool.hashrate != null)
			return false;
		if (name != trtlPool.name)
			return false;
		return network != null ? network.equals(trtlPool.network) : trtlPool.network == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (id != null ? id.hashCode() : 0);
		result = 31 * result + (hashrateRaw != null ? hashrateRaw.hashCode() : 0);
		result = 31 * result + (hashrate != null ? hashrate.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (network != null ? network.hashCode() : 0);
		return result;
	}

}
