package com.medicare.capproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.capproject.model.customers;


@Repository
public interface CustomerRepository extends JpaRepository<customers ,Long>
{

}


