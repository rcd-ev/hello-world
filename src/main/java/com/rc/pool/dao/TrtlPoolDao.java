package com.rc.pool.dao;

import com.rc.pool.domain.TrtlPool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrtlPoolDao extends JpaRepository<TrtlPool, Long> {
}
