package com.impacta.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impacta.iot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}