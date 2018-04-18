package com.rc.general.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trtl_general")
public class TrtlGeneral implements Serializable {

	@Id
	@GeneratedValue(generator = "s_trtl_general")
	@SequenceGenerator(name = "s_trtl_general", sequenceName = "s_trtl_general", allocationSize = 1)
	private Long id;

	@Column(name = "hashrate_raw")
	private String hashrateRaw;

	@Column(name = "hashrate")
	private String hashrate;

	@Column(name = "height")
	private String height;

	@Column(name = "difficulty")
	private String difficulty;

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

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

}
