package com.example.demo.repository;

import com.example.demo.data.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserContactRepository  extends JpaRepository<UserContact, UUID> {
}
