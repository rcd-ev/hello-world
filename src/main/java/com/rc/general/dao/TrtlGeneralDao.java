package com.rc.general.dao;

import com.rc.general.domain.TrtlGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrtlGeneralDao extends JpaRepository<TrtlGeneral, Long> {
}
