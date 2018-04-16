package com.rc.general.domain;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Data
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

}
