package com.microservice.github.consumer.exception;

public class GitHubApiException extends Exception {
    public GitHubApiException(String message) {
        super(message);
    }
}
