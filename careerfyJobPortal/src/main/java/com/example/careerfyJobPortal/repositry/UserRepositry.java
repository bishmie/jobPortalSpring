package com.example.careerfyJobPortal.repositry;

import com.example.careerfyJobPortal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositry extends JpaRepository<User, Integer> {
  public Optional<User> findByEmail(String email);

  @Query("SELECT COUNT(u) FROM User u")
  Long countUsers();
}
