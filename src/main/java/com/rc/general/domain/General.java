package com.rc.general.domain;

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
@Table(name = "GENERAL")
public class General implements Serializable {

	@Id
	@GeneratedValue(generator = "S_GENERAL")
	@SequenceGenerator(name = "S_GENERAL", sequenceName = "S_GENERAL", allocationSize = 1)
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
