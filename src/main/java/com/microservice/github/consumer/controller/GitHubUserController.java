package com.microservice.github.consumer.controller;

import com.microservice.github.consumer.dto.GitHubUserDto;
import com.microservice.github.consumer.exception.GitHubApiException;
import com.microservice.github.consumer.service.GitHubService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Api(tags = "GitHub User Controller")
@RequestMapping("/users")
public class GitHubUserController {

    private final GitHubService gitHubService;
    @ApiOperation(value = "Busca os dados do usuário no GitHub")
    @GetMapping("/{username}")
    public ResponseEntity<GitHubUserDto> getUser(@PathVariable String username) throws GitHubApiException {
        GitHubUserDto user = gitHubService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }
}
