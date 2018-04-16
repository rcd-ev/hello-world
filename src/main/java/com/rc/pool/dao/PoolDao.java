package com.rc.pool.dao;

import com.rc.pool.domain.Pool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoolDao extends JpaRepository<Pool, Long> {
}
