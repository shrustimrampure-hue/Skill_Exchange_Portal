package com.cse.SkillExchangePortal.repository;

import com.cse.SkillExchangePortal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}