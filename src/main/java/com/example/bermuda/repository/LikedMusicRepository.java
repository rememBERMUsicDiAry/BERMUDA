package com.example.bermuda.repository;

import com.example.bermuda.domain.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikedMusicRepository extends JpaRepository<ConfirmationToken, Long> {
}
