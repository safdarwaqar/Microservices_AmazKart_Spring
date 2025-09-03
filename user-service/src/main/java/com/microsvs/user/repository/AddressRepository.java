package com.microsvs.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsvs.user.entity.Address;
import com.microsvs.user.entity.User;
import java.util.List;
import java.util.Optional;


public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	Optional<List<Address>> findByUser(User user);
	Optional<List<Address>> findByCity(String city);
	Optional<Address> findById(Integer id);
	Optional<List<Address>> findByState(String state);

}
