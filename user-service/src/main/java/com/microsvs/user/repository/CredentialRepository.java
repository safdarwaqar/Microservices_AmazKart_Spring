package com.microsvs.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsvs.user.entity.Credential;
import com.microsvs.user.entity.User;

public interface CredentialRepository extends JpaRepository<Credential, Integer> {

	Credential findByUser(User user);

}
