package com.god.godtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.god.godtest.model.Verification;

/**
 * Represents an Repository to interact with the database
 * 
 * @author Deva Chaitanya
 * @version 1.0
 */
@Repository
public interface VerificationRepository extends JpaRepository<Verification, Long> {

}