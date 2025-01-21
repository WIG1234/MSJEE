package com.example.donservice.repositories;

import com.example.donservice.entities.Don;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DonRepository extends JpaRepository<Don, Long> {

    List<Don> findByOrganisationId(Long organisationId);

    List<Don> findByIsAchievedFalse();

    List<Don> findByCurrentAmountGreaterThan(double amount);




}
