package com.microservice.github.consumer.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TB_GIT_HUB_USER")
public class GitHubUserEntity implements Serializable {
    private static final Long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String login;
    @Column(nullable = true)
    private String avatarUrl;
    @Column(nullable = true)
    private String url;
    @Column(nullable = true)
    private String followersUrl;
    @Column(nullable = true)
    private String followingUrl;
    @Column(nullable = true)
    private String gistsUrl;
    @Column(nullable = true)
    private String organizationsUrl;
    @Column(nullable = true)
    private String reposUrl;
    @Column(nullable = false)
    private String type;
    @Column(nullable = true)
    private Boolean siteAdmin;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String blog;

    @Column(nullable = true)
    private String location;

    @Column(nullable = true)
    private String bio;

    @Column(nullable = true)
    private Integer publicRepos;

    @Column(nullable = true)
    private Integer publicGists;

    @Column(nullable = true)
    private Integer followers;

    @Column(nullable = true)
    private Integer following;

    @Column(nullable = true)
    private String createdAt;

    @Column(nullable = true)
    private String updatedAt;
}
