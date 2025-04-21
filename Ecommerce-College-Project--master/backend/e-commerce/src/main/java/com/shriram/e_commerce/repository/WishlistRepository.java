package com.shriram.e_commerce.repository;

import com.shriram.e_commerce.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist,Integer> {

}
