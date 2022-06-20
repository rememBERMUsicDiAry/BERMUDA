package com.example.bermuda.repository;

import com.example.bermuda.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikedDiaryRepository extends JpaRepository<ConfirmationToken, Long> {
}
