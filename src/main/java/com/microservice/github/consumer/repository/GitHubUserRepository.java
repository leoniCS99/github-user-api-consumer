package com.microservice.github.consumer.repository;

import com.microservice.github.consumer.model.GitHubUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitHubUserRepository extends JpaRepository<GitHubUserEntity, Long> {
    GitHubUserEntity findByLogin(String username);
}
