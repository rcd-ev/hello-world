package com.rc.general.dao;

import com.rc.general.domain.NetworkSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkSnapshotDao extends JpaRepository<NetworkSnapshot, Long> {
}
