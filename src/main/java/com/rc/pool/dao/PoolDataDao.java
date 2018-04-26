package com.rc.pool.dao;

import com.rc.pool.domain.PoolData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PoolDataDao extends JpaRepository<PoolData, Long> {
	@Query("select n from PoolData n where n.name = :name")
	Optional<PoolData> findByNameOptional(@Param("name") String name);

	@Query("select n from PoolData n where n.name = :name")
	PoolData findByName(@Param("name") String name);

	@Query("select n from PoolData n where n.enable = true")
	List<PoolData> findByActiveEnable();

	@Query("select n from PoolData n where n.enable = false")
	List<PoolData> findByInactiveEnable();
}
