package com.rc.general.domain;

import com.rc.pool.domain.TrtlPool;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
@Data
@Table(name = "trtl_network")
public class TrtlNetwork implements Serializable {

	@Id
	@GeneratedValue(generator = "s_trtl_network")
	@SequenceGenerator(name = "s_trtl_network", sequenceName = "s_trtl_network", allocationSize = 1)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "trtl_general_id")
	private TrtlGeneral generalNetwork;

	/*@OneToMany(mappedBy = "network", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//	@OneToMany(mappedBy = "network", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<TrtlPool> pools = new HashSet<>();
*/

	@OneToMany(mappedBy = "network", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<TrtlPool> pools = new ArrayList<>();

}
