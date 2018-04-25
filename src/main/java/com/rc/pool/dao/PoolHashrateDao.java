package com.rc.pool.dao;

import com.rc.pool.domain.PoolHashrate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoolHashrateDao extends JpaRepository<PoolHashrate, Long> {
}
