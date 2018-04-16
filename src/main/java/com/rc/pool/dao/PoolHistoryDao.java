package com.rc.pool.dao;

import com.rc.pool.domain.PoolHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoolHistoryDao extends JpaRepository<PoolHistory, Long> {
}
