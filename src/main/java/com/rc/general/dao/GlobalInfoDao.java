package com.rc.general.dao;

import com.rc.general.domain.GlobalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalInfoDao extends JpaRepository<GlobalInfo, Long> {
}
