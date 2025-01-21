package com.example.donservice.repositories;

import com.example.donservice.entities.UserDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface UserDonRepository extends JpaRepository<UserDon, Long> {

    List<UserDon> findByDonId(Long donId);

    List<UserDon> findByUserId(Long userId);




}
