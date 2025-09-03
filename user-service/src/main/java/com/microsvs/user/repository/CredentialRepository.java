package com.microsvs.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsvs.user.entity.Credential;

public interface CredentialRepository extends JpaRepository<Credential, Integer> {

}
