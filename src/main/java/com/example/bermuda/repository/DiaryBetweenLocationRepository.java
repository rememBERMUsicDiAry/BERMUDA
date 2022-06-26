package com.example.bermuda.repository;

import com.example.bermuda.domain.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryBetweenLocationRepository extends JpaRepository<ConfirmationToken, Long> {
}
