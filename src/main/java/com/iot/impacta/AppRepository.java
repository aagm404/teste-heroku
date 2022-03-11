package com.iot.impacta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iot.impacta.entity.Login;

@Repository
public interface AppRepository extends JpaRepository<Login, Long> {

}
