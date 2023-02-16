package com.microservice.github.consumer.service;

import com.microservice.github.consumer.client.GitHubApiClient;
import com.microservice.github.consumer.dto.GitHubUserDto;
import com.microservice.github.consumer.exception.GitHubApiException;
import com.microservice.github.consumer.model.GitHubUserEntity;
import com.microservice.github.consumer.repository.GitHubUserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GitHubService {
    private final GitHubApiClient gitHubApiClient;
    private final GitHubUserRepository gitHubUserRepository;
    private final ModelMapper modelMapper;
    @Value("${github.token}")
    private String TOKEN;

    public GitHubUserDto getUserByUsername(String username) throws GitHubApiException {
        try {
            GitHubUserEntity gitHubUserEntity = gitHubUserRepository.findByLogin(username);

            if (gitHubUserEntity == null) {
                GitHubUserDto gitHubUser = gitHubApiClient.getClientUserByUsername(TOKEN, username).getBody();
                gitHubUserEntity = modelMapper.map(gitHubUser, GitHubUserEntity.class);
                gitHubUserRepository.save(gitHubUserEntity);
            }
            return modelMapper.map(gitHubUserEntity, GitHubUserDto.class);
        } catch (Exception e) {
            throw new GitHubApiException("Ocorreu um erro ao chamar a API do GitHub: " + e.getMessage());
        }
    }
}