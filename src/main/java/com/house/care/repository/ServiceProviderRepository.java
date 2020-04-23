package com.house.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.house.care.domain.ServiceProvider;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

}
