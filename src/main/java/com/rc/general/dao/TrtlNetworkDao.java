package com.rc.general.dao;

import com.rc.general.domain.TrtlNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrtlNetworkDao extends JpaRepository<TrtlNetwork, Long> {
}
