package com.shriram.e_commerce.repository;

import com.shriram.e_commerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
