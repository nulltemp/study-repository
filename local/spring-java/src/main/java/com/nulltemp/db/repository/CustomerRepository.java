package com.nulltemp.db.repository;

import com.nulltemp.db.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	List<CustomerEntity> findByLastName(@Param("lastName") String lastName);
}
