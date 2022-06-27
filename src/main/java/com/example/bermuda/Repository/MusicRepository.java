package com.example.bermuda.Repository;

import com.example.bermuda.Domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
