package com.sparta.jwtsession.post.dto;

import lombok.Getter;

import java.net.URL;

@Getter
public class PostRequestDto {
    private String email;
    private String title;
    private String contents;
    private String imgUrl;
}
