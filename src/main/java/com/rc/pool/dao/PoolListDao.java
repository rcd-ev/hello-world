package com.rc.pool.dao;

import com.rc.pool.domain.PoolList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoolListDao extends JpaRepository<PoolList, Long> {
}
