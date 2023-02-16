package com.microservice.github.consumer.service;

import com.microservice.github.consumer.client.GitHubApiClient;
import com.microservice.github.consumer.dto.GitHubUserDto;
import com.microservice.github.consumer.exception.GitHubApiException;
import com.microservice.github.consumer.model.GitHubUserEntity;
import com.microservice.github.consumer.repository.GitHubUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class GitHubServiceTest {

    private GitHubService gitHubService;

    @Mock
    private GitHubApiClient gitHubApiClient;

    @Mock
    private GitHubUserRepository gitHubUserRepository;

    @Mock
    private ModelMapper modelMapper;

    @Value("${github.token}")
    private String TOKEN;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        gitHubService = new GitHubService(gitHubApiClient, gitHubUserRepository, modelMapper);
    }

    @Test
    void testGetUserByUsernameWhenUserExists() throws GitHubApiException {
        GitHubUserEntity gitHubUserEntity = new GitHubUserEntity();
        gitHubUserEntity.setId(1L);
        gitHubUserEntity.setLogin("test_user");

        GitHubUserDto gitHubUserDto = new GitHubUserDto();
        gitHubUserDto.setId(1L);
        gitHubUserDto.setLogin("test_user");

        when(gitHubUserRepository.findByLogin(anyString())).thenReturn(gitHubUserEntity);
        when(modelMapper.map(gitHubUserEntity, GitHubUserDto.class)).thenReturn(gitHubUserDto);

        GitHubUserDto result = gitHubService.getUserByUsername("test_user");

        assertEquals(gitHubUserDto, result);
    }

    @Test
    void testGetUserByUsernameWhenUserDoesNotExist() throws GitHubApiException {
        GitHubUserDto gitHubUserDto = new GitHubUserDto();
        gitHubUserDto.setId(1L);
        gitHubUserDto.setLogin("test_user");

        when(gitHubUserRepository.findByLogin(anyString())).thenReturn(null);
        when(gitHubApiClient.getClientUserByUsername(TOKEN, "test_user")).thenReturn(ResponseEntity.ok(gitHubUserDto));
        when(modelMapper.map(gitHubUserDto, GitHubUserEntity.class)).thenReturn(new GitHubUserEntity());
        when(modelMapper.map(new GitHubUserEntity(), GitHubUserDto.class)).thenReturn(gitHubUserDto);

        GitHubUserDto result = gitHubService.getUserByUsername("test_user");

        assertEquals(gitHubUserDto, result);
    }
}
