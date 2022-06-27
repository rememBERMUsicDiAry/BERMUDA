package com.example.bermuda.Repository;

import com.example.bermuda.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
