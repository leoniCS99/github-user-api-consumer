package com.microservice.github.consumer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GitHubUserDto {
    private String login;
    private Long id;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    private String url;
    @JsonProperty("followers_url")
    private String followersUrl;
    @JsonProperty("following_url")
    private String followingUrl;

    @JsonProperty("gists_url")
    private String gistsUrl;

    @JsonProperty("organizations_url")
    private String organizationsUrl;

    @JsonProperty("repos_url")
    private String reposUrl;
    private String type;

    @JsonProperty("site_admin")
    private Boolean siteAdmin;
    private String name;
    private String blog;
    private String location;
    private String bio;
    @JsonProperty("public_repos")
    private Integer publicRepos;
    @JsonProperty("public_gists")
    private Integer publicGists;
    private Integer followers;
    private Integer following;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
}
