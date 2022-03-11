package com.iot.impacta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iot.impacta.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}