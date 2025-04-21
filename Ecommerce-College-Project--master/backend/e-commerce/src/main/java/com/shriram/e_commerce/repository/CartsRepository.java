package com.shriram.e_commerce.repository;

import com.shriram.e_commerce.entity.Carts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartsRepository extends JpaRepository<Carts,Integer> {
}
