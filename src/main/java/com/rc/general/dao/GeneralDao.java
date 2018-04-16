package com.rc.general.dao;

import com.rc.general.domain.General;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralDao extends JpaRepository<General, Long> {
}
