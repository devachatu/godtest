package com.god.godtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.god.godtest.model.Verification;

@Repository
public interface VerificationRepository extends JpaRepository<Verification, Long> {

}