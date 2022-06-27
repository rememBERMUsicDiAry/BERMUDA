package com.example.bermuda.Repository;

import com.example.bermuda.Domain.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikedMusicRepository extends JpaRepository<ConfirmationToken, Long> {
}
