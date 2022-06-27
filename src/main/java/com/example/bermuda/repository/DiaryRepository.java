package com.example.bermuda.Repository;

import com.example.bermuda.Domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
