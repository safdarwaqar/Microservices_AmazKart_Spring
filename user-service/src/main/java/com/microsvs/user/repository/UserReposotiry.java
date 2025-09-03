package com.microsvs.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsvs.user.entity.User;
import com.microsvs.user.entity.Address;
import com.microsvs.user.entity.Credential;

import java.util.List;
import java.util.Set;

public interface UserReposotiry extends JpaRepository<User, String> {

	Optional<User> findByEmail(String email);

	Optional<User> findById(String id);

	List<User> findByAddress(Set<Address> address);

	List<User> findByCredential(Credential credential);

	Optional<User> findByPhone(String phone);

	boolean existsByEmail(String email);

	boolean existsByPhone(String phone);


}
