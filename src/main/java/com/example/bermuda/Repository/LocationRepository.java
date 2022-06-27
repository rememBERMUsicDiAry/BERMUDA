package com.example.bermuda.Repository;

import com.example.bermuda.Domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
