package com.microservice.github.consumer.client;

import com.microservice.github.consumer.dto.GitHubUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "github-api", url = "https://api.github.com", path = "/users")
public interface GitHubApiClient {

    @GetMapping("/{username}")
    ResponseEntity<GitHubUserDto> getClientUserByUsername(
            @RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("username") String username
    );
}
