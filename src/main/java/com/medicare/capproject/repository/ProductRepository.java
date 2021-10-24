package com.medicare.capproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.capproject.model.products;


@Repository
public interface ProductRepository extends JpaRepository<products ,Long> {

}
