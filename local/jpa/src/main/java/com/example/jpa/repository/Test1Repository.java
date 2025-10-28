package com.example.jpa.repository;

import com.example.jpa.entity.Test1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Test1Repository extends JpaRepository<Test1Entity, Long> {
}
